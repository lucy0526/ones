package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavoriteDao {

    public int findCountByTid(int tid);

    public Favorite findByTidAndUid(int tid, int uid);

    void add(int tid, int uid);
}
