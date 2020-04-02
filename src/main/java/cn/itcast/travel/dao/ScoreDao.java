package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Score;

import java.util.List;

public interface ScoreDao {
    public List<Score> findAll();

    public void addScore(Score score);

    public List<Score> findByTid(int tid);

}
