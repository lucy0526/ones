package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.TestTol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/common/*")
public class CommonServlet extends BaseServlet {

    /*
    分页
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        String tname = request.getParameter("tname");
        tname = new String(tname.getBytes("iso-8859-1"), "utf-8");

        if ("null".equalsIgnoreCase(tname))
            tname = null;

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


}
