package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.TestTol;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.TestTolService;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String tid, int uid) {
        Favorite favorite = favoriteDao.findByTidAndUid(Integer.parseInt(tid), uid);
        if (favorite != null) {
            return true;
        } else
            return false;
    }

    @Override
    public void add(String tid, int uid) {
        favoriteDao.add(Integer.parseInt(tid), uid);
    }

    @Override
    public PageBean<Favorite> pageQuery(int uid, int currentPage, int pageSize) {
        PageBean<Favorite> pb = new PageBean<Favorite>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        int totalCount = favoriteDao.findTotalCount(uid);
        pb.setTotalCount(totalCount);

        int start = (currentPage-1) * pageSize;
        List<Favorite> list = favoriteDao.findByPage(uid, start, pageSize);
        pb.setList(list);

        int totalPage = totalCount%pageSize == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
