package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Dev;
import cn.itcast.travel.domain.IAndScoreUsers;
import cn.itcast.travel.domain.Score;
import cn.itcast.travel.domain.ScoreAndDev;
import cn.itcast.travel.service.BasedUserReCommendService;
import cn.itcast.travel.service.DevService;
import cn.itcast.travel.service.ScoreService;
import cn.itcast.travel.service.impl.BasedUserReCommendServiceImpl;
import cn.itcast.travel.service.impl.DevServiceImpl;
import cn.itcast.travel.service.impl.ScoreServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/score/*")
public class ScoreServlet extends BaseServlet {
    private BasedUserReCommendService basedUserReCommendService = new BasedUserReCommendServiceImpl();
    private ScoreService scoreService = new ScoreServiceImpl();
    private DevService devService = new DevServiceImpl();

    /**
     * 用户评分
     */
    public void addScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uidStr = request.getParameter("uid");
        String tidStr = request.getParameter("tid");
        String scoreStr = request.getParameter("score");
        int uid = Integer.parseInt(uidStr);
        int tid = Integer.parseInt(tidStr);
        float scoreFloat = Float.parseFloat(scoreStr);


//        1. 删除推荐表中uid+tid数据
        basedUserReCommendService.deleteByUidAndTid(uid, tid);

        Score score = new Score();
        score.setUid(uid);
        score.setTid(tid);
        score.setScore(scoreFloat);

        //查询用户是否已经打过分
        if (scoreService.findByUidAndTid(score.getUid(), score.getTid()).size() == 0)//没有打过分
        {

//            . 更新用户相异度表
            updateUserDev(score);


//            . 保存到用户-物品评价表
            scoreService.addScore(score);

//            给neibAll推荐现在主用户评价过得这一个物品item1
            addPreScoreToneibAll(score.getUid(), score.getTid());

            basedUserReCommendService.deleteByUidAndTid(uid, tid);


        }


        /*
        boolean isAdd = scoreService.addScore(score);

//        3. 更新用户相异度表
        *//*
        添加成功才更新，否则说明该用户已经评论分，不再修改
        添加成功说明以前用户没用评价过，那么评价过得用户不可能有他（最近邻中找不到）
         *//*
        if (isAdd)//
            updateUserDev(score);*/

    }

    /**
     * 给neibAll推荐现在主用户评价过得这一个物品item1
     */
    private void addPreScoreToneibAll(int uid, int tid) {

        //找到用户的相关户
        List<Dev> relationsToUser = devService.findByUid(uid);
        //找到所有最近邻
        List<Dev> neibToUser = selectNeib(relationsToUser);
        //给nei预测对item1的评分
        for (Dev nei : neibToUser) {

            //得到最近邻的id
            int neiId = findDevId2(uid, nei);
            //查询是否给item1打过分
            List<Score> isScore = scoreService.findByUidAndTid(neiId, tid);
            if (isScore.size() == 0) {//没有打过分
                //计算最近邻neiId对item1的预测评分,并保存
                getPreScore(neiId, tid);
            }

        }

    }

    /**
     * 预测uid给tid打得分
     */
    private void getPreScore(int uid, int tid) {
        //找到uid的所有相关户
//        List<Dev> relationsToU = devService.findByUid(uid);
        List<Dev> relationsToU = devService.findAllRelations(uid);

        //找到uid的所有最近邻
        List<Dev> neisToU = selectNeib(relationsToU);

        float totalUp = 0;
        float totalCount = 0;
        float p = 0;

        for (Dev nei : neisToU) {
            //得到最近邻的id
            int neiId = findDevId2(uid, nei);
            //该最近邻占uid的地位
            int count = nei.getDev_count();
            totalCount += count;

            //查询最近邻是否给tid打过分
            List<Score> isScore = scoreService.findByUidAndTid(neiId, tid);
            if (isScore.size() != 0)//最近邻给tid打过分
            {
                Score score = isScore.get(0);
                totalUp += count * score.getScore();//最近邻打得分
            }
        }

        //预测
        p = totalUp / totalCount;

        //保存
        saveNewP(uid, p, tid);
    }

    /**
     * 更新用户相异度表
     */
    public void updateUserDev(Score score) {
        int uid = score.getUid();
        float a = score.getScore();//用户对tid的打分

//        1. 从用户-物品评价表中找到对tid评过分的 用户集
        List<Score> ScoresSameTid = scoreService.findByTid(score.getTid());
        List<Dev> devsChanged = new LinkedList<Dev>();


//        2. 更新uid与ScoresSameTid之间的用户相异度数据
        for (Score score2 : ScoresSameTid) {
            Dev dev = new Dev();

            int uid2 = score2.getUid();
            float b = score2.getScore();

            //查询用户相异度表，看uid2与uid的是否以前评价过一样的物品，即已经有了dev记录
            Dev devOld = devService.findByUidAndUid2(uid, uid2);

//            uid2与uid没有dev记录
            if (devOld == null) {
                devOld = new Dev();
                devOld.setUid1(uid);
                devOld.setUid2(uid2);
                devOld.setDev(Math.abs(a - b));
                devOld.setDev_count(1);

                devService.addDev(devOld);
            } else {//若表中有User1与user2的dev
                float devNew = devOld.getDev() + Math.abs(a - b);
                int countNew = devOld.getDev_count() + 1;
                devOld.setDev(devNew);
                devOld.setDev_count(countNew);

                devService.updateDev(devOld);
            }

            //dev改变了的相关户
            devsChanged.add(devOld);
        }

//        若dev改变了的相关户user3不为空
        if (devsChanged.size() > 0) {
            //选出最近邻：dev改变了的最近邻，找出他评价过得物品进行修改
            List<Dev> devsNeib = selectNeib(devsChanged);

//         3. 更新推荐表
            updateBasedUserRecommend(uid, devsNeib);

        }
    }


    /**
     * 选出最近邻：
     * dev小于 4
     * 次数大于 2
     */
    private List<Dev> selectNeib(List<Dev> devsChanged) {
        List<Dev> devsNeib = new LinkedList<Dev>();
        for (Dev dev : devsChanged) {
            /*//用户相异度小于4且同评价过2个以上的物品
            if (dev.getDev() < 4 && dev.getDev_count() > 2) {
                devsNeib.add(dev);
            }*/
            //用户相异度大于4且同评价过>=2的物品
            if (dev.getDev() < 4 && dev.getDev_count() > 1) {
                devsNeib.add(dev);
            }
        }

        return devsNeib;
    }

    /**
     * 更新推荐表
     */
    private void updateBasedUserRecommend(int uid, List<Dev> devsNeib) {
        //更新user的推荐表
        updateToUser(uid, devsNeib);
        //由于user3（dev改变了的最近邻）与user关系改变，因此user3的推荐表也要变
        updateToNeib(uid, devsNeib);

    }

    /**
     * 更新对user3的推荐
     * 推荐的是主用户的所有物品
     */
    private void updateToNeib(int uid, List<Dev> devsNeib) {
        for (Dev dev : devsNeib) {
            //得到要进行推荐的用户id：对称矩阵，只保留了一个，因此要检查
            int idUser3 = dev.getUid2();
            if (idUser3 == uid) {
                idUser3 = dev.getUid1();
            }
            //得到user3的相关户
            List<Dev> devRelationsToUser3 = devService.findByUid(idUser3);
            //得到user3的最近邻
            List<Dev> neibListToUser3 = selectNeib(devRelationsToUser3);

            //得到user评价过的物品
            List<Score> userScores = scoreService.findByUid(uid);

            for (Score score : userScores) {
                int tid = score.getTid();//user评价过的物品id
                List<Score> oneScore = scoreService.findByUidAndTid(idUser3, tid);//查询user3是否评价过
                if (oneScore.size() == 0)//沒有
                {
                    //估算分數
                    float totalUp = 0;
                    float totalCount = 0;
                    float p = 0;

                    for (Dev nei : neibListToUser3) {
                        float count = nei.getDev_count();
                        //得到user3的邻居id
                        int neiId = nei.getUid2();
                        if (neiId == idUser3) {
                            neiId = nei.getUid1();
                        }

                        List<Score> isScore = scoreService.findByUidAndTid(neiId, tid);
                        if (isScore.size() != 0) {
                            float r = scoreService.findByUidAndTid(neiId, tid).get(0).getScore();
                            totalUp += count * r;
                            totalCount += count;
                        }
                    }

                    p = totalUp / totalCount;
                    saveNewP(idUser3, p, tid);
                }

            }
        }
    }


    /**
     * 更新对主用户的推荐
     */
    private void updateToUser(int uid, List<Dev> devsNeib) {
        //        1. 找出user3评价过的物品itemi

        //保存user3评价过的物品itemi集合
        Set<IAndScoreUsers> iAndScoreUsersSet = new HashSet<IAndScoreUsers>();

//       找到user3评价过的物品集itemi
        for (Dev dev : devsNeib)//对于每个最近邻
        {
            int user3Id;//最近邻的id
            user3Id = findDevId2(uid, dev);//在对称矩阵里面查找

            //1. 1 查找用户-物品评价表，找到user3评价过的物品itemi的id
            List<Score> scoreList = scoreService.findByUid(user3Id);

            //1. 2 将itemi存入set<IAndScoreUsers>
            for (Score score : scoreList) {
                /**
                 ***最近邻用户的每个评价过的物品：
                 */

                //设置物品的id
                IAndScoreUsers iAndScoreUsers = new IAndScoreUsers();
                iAndScoreUsers.setTid(score.getTid());

                /*
                    保存评价过该物品的所有最近邻用户信息:
     -----------------没有包括dev没有改变的最近邻(应该改为所有最近邻)
                 */
                //评价过该物品的用户信息
                ScoreAndDev scoreAndDev = new ScoreAndDev();
                scoreAndDev.setUid(score.getUid());
                scoreAndDev.setDev_count(dev.getDev_count());//所有物品一样的最近邻
                scoreAndDev.setScore(score.getScore());
                //将用户放入新的用户列表
                List<ScoreAndDev> scoreAndDevList = new LinkedList<>();
                scoreAndDevList.add(scoreAndDev);//放入用户信息

                //将新的用户列表作为该物品的用户列表
                iAndScoreUsers.setScoreAndDevList(scoreAndDevList);

                /*
                    加入失败:
                        之前已经有用户评价过它,找到他的用户列表，放入该用户信息
                 */
                if (!iAndScoreUsersSet.add(iAndScoreUsers)) {
                    //找到这个物品，加入用户信息
                    for (IAndScoreUsers hadItem : iAndScoreUsersSet) {
                        if (hadItem.getTid() == score.getTid()) {
                            List list = hadItem.getScoreAndDevList();
                            list.add(scoreAndDev);//放入用户信息
                        }
                    }
                }
            }
        }

//        2. 筛选出user没有评价过得物品集
        List<Score> scoreListUser = scoreService.findByUid(uid);
        for (Score score : scoreListUser) {
            Iterator<IAndScoreUsers> it = iAndScoreUsersSet.iterator();
            while (it.hasNext()) {
                IAndScoreUsers iAndScoreUsers = it.next();
                if (score.getTid() == iAndScoreUsers.getTid())//用户已经评价过该物品，不再估计p
                {
                    it.remove();
                }

            }
        }

//        3. 计算每个item的评分
        for (IAndScoreUsers iAndScoreUsers : iAndScoreUsersSet) {
            float totalUp = 0;
            float totalCount = 0;
            float p = 0;

            for (ScoreAndDev scoreAndDev : iAndScoreUsers.getScoreAndDevList()) {
                totalUp += scoreAndDev.getDev_count() * scoreAndDev.getScore();
                totalCount += scoreAndDev.getDev_count();
            }
            p = totalUp / totalCount;

//            4. 更新用户-物品未评价表
            /**
             * 查询用户-物品未评价表中是否已有对该物品的预测过
             */

            int iAndScoreUsersTid = iAndScoreUsers.getTid();
            saveNewP(uid, p, iAndScoreUsersTid);

        }
    }

    /**
     * 保存预测评分
     */
    private void saveNewP(int uid, float p, int tid) {
        //查询是否有过预测
        boolean hadPreScore = basedUserReCommendService.hadPreScore(uid, tid);
        if (hadPreScore) {
            //有过预测，直接更新
            basedUserReCommendService.updateByUidAndTid(p, uid, tid);
        } else {
            //没有预测，添加
            basedUserReCommendService.addPreScore(p, uid, tid);
        }
    }

    /**
     * 找到最近邻的id
     */
    private int findDevId2(int uid1, Dev dev) {
        int uid2 = dev.getUid2();
        if (uid2 == uid1) {
            uid2 = dev.getUid1();
        }
        return uid2;
    }
}
