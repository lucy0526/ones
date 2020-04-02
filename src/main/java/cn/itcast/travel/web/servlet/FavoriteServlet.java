package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.TestTol;
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
import java.util.LinkedList;

@WebServlet("/favorite/*")
public class FavoriteServlet extends BaseServlet {
    private FavoriteService favoriteService = new FavoriteServiceImpl();
    private TestTolService testTolService = new TestTolServiceImpl();

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String uidString = request.getParameter("uid");
        int uid = Integer.parseInt(uidString);

        int currentPage = 1;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        }

        int pageSize = 4;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        //查询数据库
        PageBean<Favorite> pbFavorite = favoriteService.pageQuery(uid, currentPage, pageSize);

        PageBean<TestTol> pbTestTol = new PageBean<TestTol>();
        pbTestTol.setList(new LinkedList<TestTol>());

//        转移数据
        pbTestTol.setTotalPage(pbFavorite.getTotalPage());
        pbTestTol.setTotalCount(pbFavorite.getTotalCount());
        pbTestTol.setPageSize(pbFavorite.getPageSize());
        pbTestTol.setCurrentPage(pbFavorite.getCurrentPage());

        for (int i=0; i<pbFavorite.getList().size(); i++)
        {
            int testTolId = pbFavorite.getList().get(i).getTid();
            TestTol testTol = testTolService.findOne(Integer.toString(testTolId));
            pbTestTol.getList().add(testTol);
        }

        writeValue(response, pbTestTol);
    }
}
