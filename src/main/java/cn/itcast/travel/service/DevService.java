package cn.itcast.travel.service;

import cn.itcast.travel.domain.Dev;
import cn.itcast.travel.domain.Score;

import java.util.List;

public interface DevService {
    public Dev findByUidAndUid2(int uid, int uid2);

    void addDev(Dev dev);

    public void updateDev(Dev dev);

    public List<Dev> findByUid(int idUser3);

    public List<Dev> findAllRelations(int uid);
}
