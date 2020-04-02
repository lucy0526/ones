package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.UserSetService;
import cn.itcast.travel.service.impl.UserSetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/recommend/*")
public class RecommendServlet extends BaseServlet {
    UserSetService userSetService = new UserSetServiceImpl();

    public void findRecommendByUserSet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        writeValue(response, userSetService.findAllRecommendByUId(uid));
    }
}
