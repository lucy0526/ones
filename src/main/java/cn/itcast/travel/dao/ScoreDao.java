package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Score;

import java.util.List;

public interface ScoreDao {
    public List<Score> findAll();

    public void addScore(Score score);

    public List<Score> findByTid(int tid);

    public List<Score> findByUid(int uid);

    public List<Score> findByUidAndTid(int uid, int tid);
}
