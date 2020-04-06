package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Dev;

import java.util.List;

public interface DevDao {
    public Dev findByUidAndUid2(int uid, int uid2);

    public void addDev(Dev dev);

    public void updateDev(Dev dev);

    public List<Dev> findByUid(int idUser3);

    public List<Dev> findAllRelationsByUid(int uid);
}
