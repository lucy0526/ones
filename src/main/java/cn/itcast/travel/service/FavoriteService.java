package cn.itcast.travel.service;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.TestTol;

public interface FavoriteService {

    public boolean isFavorite(String tid, int uid);

    void add(String tid, int uid);

    PageBean<Favorite> pageQuery(int uid, int currentPage, int pageSize);
}
