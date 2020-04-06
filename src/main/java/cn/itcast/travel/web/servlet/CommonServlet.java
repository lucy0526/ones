package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Common;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.TestTol;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.CommonService;
import cn.itcast.travel.service.impl.CommonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/common/*")
public class CommonServlet extends BaseServlet {
    private CommonService commonService = new CommonServiceImpl();

    /*
    分页
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String tidStr = request.getParameter("tid");

        int tid = 0;
//        将字符串转为数字
        if (!"null".equalsIgnoreCase(tidStr) && tidStr != null && tidStr.length() > 0) {
            tid = Integer.parseInt(tidStr);
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
        PageBean<Common> pb = commonService.pageQuery(tid, currentPage, pageSize);
        writeValue(response, pb);
    }

    /**
     * 添加评论
     */
    public void addCommon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到用户id
        User user = (User) request.getSession().getAttribute("user");
        if (user != null)
        {
            int uid = user.getUid();
            //得到tid
            String tidStr = request.getParameter("tid");
            int tid = Integer.parseInt(tidStr);
            //得到内容
            String commonContent = request.getParameter("commonContent");
//            commonContent = URLDecoder.decode(request.getParameter("commonContent"),"UTF-8");
//            System.out.println(commonContent);

            if (commonContent == null)
            {
                commonContent = " ";
            }

            commonService.addCommon(uid, tid, commonContent);

            boolean flag = true;
            writeValue(response, flag);

        }

    }


}
