package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.BasedUserRecommend;
import cn.itcast.travel.domain.Dev;
import cn.itcast.travel.domain.Score;
import cn.itcast.travel.service.BasedUserReCommendService;
import cn.itcast.travel.service.ScoreService;
import cn.itcast.travel.service.impl.BasedUserReCommendServiceImpl;
import cn.itcast.travel.service.impl.ScoreServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/score/*")
public class ScoreServlet extends BaseServlet {
    private BasedUserReCommendService basedUserReCommendService = new BasedUserReCommendServiceImpl();
    private ScoreService scoreService = new ScoreServiceImpl();

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

//        2. 保存到用户-物品评价表
        Score score = new Score();
        score.setUid(uid);
        score.setTid(tid);
        score.setScore(scoreFloat);
        scoreService.addScore(score);

//        3. 更新用户相异度表
        updateUserDev(score);

    }

    /**
     * 更新用户相异度表
     */
    public void updateUserDev(Score score){
        int uid = score.getUid();
        float a = score.getScore();//用户对tid的打分

//        1. 从用户-物品评价表中找到对tid评过分的 用户集
        List<Score> ScoresSameTid =  scoreService.findByTid(score.getTid());

//        2. 更新uid与ScoresSameTid之间的用户相异度数据
        for (Score score2 : ScoresSameTid){
            Dev dev = new Dev();
            float b =
        }

    }
}
