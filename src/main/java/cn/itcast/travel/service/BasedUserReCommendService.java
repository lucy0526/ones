package cn.itcast.travel.service;

import cn.itcast.travel.domain.BasedUserRecommend;

import java.util.List;

public interface BasedUserReCommendService {
    public void deleteByUidAndTid(int uid, int tid);

    public boolean hadPreScore(int uid, int tid);

    public void updateByUidAndTid(float preScore, int uid, int tid);

    public void addPreScore(float p, int uid, int tid);

    public List<BasedUserRecommend> findByUid(int uid);
}
