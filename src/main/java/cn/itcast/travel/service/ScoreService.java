package cn.itcast.travel.service;

import cn.itcast.travel.domain.Score;

import java.util.List;

public interface ScoreService {
    public List<Score> findByUid(int uid);
    public List<Score> findByUidAndTid(int uid, int tid);

    public boolean addScore(Score score);
    public List<Score> findByTid(int tid);

}
