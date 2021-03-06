package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.TestTol;

import java.util.List;

public interface FavoriteDao {

    public int findCountByTid(int tid);

    public Favorite findByTidAndUid(int tid, int uid);

    void add(int tid, int uid);

    int findTotalCount(int uid);

    List<Favorite> findByPage(int uid, int start, int pageSize);

}
