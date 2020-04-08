package cn.itcast.travel.dao;

import cn.itcast.travel.domain.BasedUserRecommend;

import java.util.List;

public interface BasedUserReCommendDao {
    public void deleteByUidAndTid(int uid, int tid);

    public BasedUserRecommend findOneByUidAndTid(int uid, int tid);

    public void updateByUidAndTid(float preScore, int uid, int tid);

    public void addPreScore(float p, int uid, int tid);

    public List<BasedUserRecommend> findByUid(int uid);
}
