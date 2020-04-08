package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.BasedUserRecommend;
import cn.itcast.travel.domain.RecommendToPage;
import cn.itcast.travel.domain.TestTol;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.BasedUserReCommendService;
import cn.itcast.travel.service.TestTolService;
import cn.itcast.travel.service.UserSetService;
import cn.itcast.travel.service.impl.BasedUserReCommendServiceImpl;
import cn.itcast.travel.service.impl.TestTolServiceImpl;
import cn.itcast.travel.service.impl.UserSetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/recommend/*")
public class RecommendServlet extends BaseServlet {
    UserSetService userSetService = new UserSetServiceImpl();
    BasedUserReCommendService basedUserReCommendService = new BasedUserReCommendServiceImpl();
    TestTolService testTolService = new TestTolServiceImpl();

    public void findRecommendByUserSet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        writeValue(response, userSetService.findAllRecommendByUId(uid));
    }


    /**
     * 查询推荐：
     * 如果用户没有登录，查询被收藏次数最多的
     */
    public void findRecommendByUid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            List<BasedUserRecommend> recommendList = new LinkedList<>();
            int uid = user.getUid();
            recommendList = basedUserReCommendService.findByUid(uid);
            List<RecommendToPage> recommendToPageList = new LinkedList<RecommendToPage>();

            for (BasedUserRecommend reCommend : recommendList) {
                TestTol testTol = testTolService.findOne(Integer.toString(reCommend.getTid()));
                RecommendToPage recommendToPage = new RecommendToPage();
                recommendToPage.setCount(testTol.getCount());
                recommendToPage.setPreScore(reCommend.getPreScore());
                recommendToPage.setTid(reCommend.getTid());
                recommendToPage.setTimage(testTol.getTimage());
                recommendToPage.setTname(testTol.getTname());
                recommendToPageList.add(recommendToPage);
            }
            writeValue(response, recommendToPageList);
        } else {
            List<TestTol> newest = testTolService.findPopularity();
            writeValue(response, newest);
        }
    }


}
