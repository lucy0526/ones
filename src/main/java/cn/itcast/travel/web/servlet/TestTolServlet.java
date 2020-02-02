package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.TestTol;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.TestTolService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.TestTolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/testTol/*")
public class TestTolServlet extends BaseServlet {
    private TestTolService testTolService = new TestTolServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();


    public void findNewest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        writeValue(response, testTolService.findNewest());
    }
    public void findPopularity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TestTol> newest = testTolService.findPopularity();
        writeValue(response, newest);
    }


    /**
     * 分页处理
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        String tname = request.getParameter("tname");
        tname = new String(tname.getBytes("iso-8859-1"), "utf-8");

        int cid = 0;
//        将字符串转为数字
        if (!"null".equalsIgnoreCase(cidStr) && cidStr != null && cidStr.length() > 0) {
            cid = Integer.parseInt(cidStr);
        }

        int currentPage = 1;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        }

        int pageSize = 5;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        //查询数据库
        PageBean<TestTol> pb = testTolService.pageQuery(cid, currentPage, pageSize, tname);
        writeValue(response, pb);
    }

    /**
     * 详细信息
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tid = request.getParameter("tid");
        TestTol testTol = testTolService.findOne(tid);
        writeValue(response, testTol);
    }

    /**
     * 判断是否收藏
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tid = request.getParameter("tid");
        User user = (User) request.getSession().getAttribute("user");
        int uid = 0;
        if (user != null) {
            uid = user.getUid();
        }
        boolean flag = favoriteService.isFavorite(tid, uid);
        writeValue(response, flag);
    }

    /**
     * 用户添加收藏
     */
    public void addFavorite(HttpServletRequest request, HttpServletResponse response){
        String tid = request.getParameter("tid");
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null)
            return;
        else
            uid = user.getUid();
        favoriteService.add(tid, uid);

    }

}
