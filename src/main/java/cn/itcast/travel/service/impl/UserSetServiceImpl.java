package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.ScoreDao;
import cn.itcast.travel.dao.UserSetDao;
import cn.itcast.travel.dao.impl.ScoreDaoImpl;
import cn.itcast.travel.dao.impl.UserSetDaoImpl;
import cn.itcast.travel.service.UserSetService;

public class UserSetServiceImpl implements UserSetService {
    ScoreDao scoreDao = new ScoreDaoImpl();
    UserSetDao userSetDao = new UserSetDaoImpl();
    /**
     * 更新数据库
     * @param uid
     * @return
     */
//    public void updateRecommend(int uid){
//        List<Score> scoreList = scoreDao.findAll();
//        UserSet userSet = new UserSet();
//
//        for(int i=0; i<scoreList.size(); i++){//遍历所有评分集合
//            Score score = scoreList.get(i);
//            //查询集合中是否已经有该用户
//            UserSet.User user = userSet.getUser(score.getUid());
//            if (user != null) {
//                //已经有该用户
//                user.set(score.getTid(), score.getScore());//对某个工具的评分
//            }else {
//                //没有该用户
//                user = userSet.put(score.getUid());//创建用户
//                user.set(score.getTid(), score.getScore());//对某个工具的评分
//            }
//        }
///*
//        for(int i=0; i<scoreList.size(); i++){//遍历所有评分集合
////            查找该用户之前是否已经评价过
//            Boolean flag = false;
//            for (int j=0; j<userSet.users.size(); j++)
//            {
//                if (userSet.users.get(j).uid == )
//            }
//
//        }
//*/
//
//        RecommendUser recommend = new RecommendUser();
//        List<UserSet.Set> recommendations = recommend.recommend(uid, userSet);
//        //更新数据库
//        userSetDao.updateRecommendation(uid, recommendations);
//
//    }

    public int findAllRecommendByUId(int uid){
        return userSetDao.findAllRecommendByUId(uid);
    }
}
