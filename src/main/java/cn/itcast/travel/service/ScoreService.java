package cn.itcast.travel.service;

import cn.itcast.travel.domain.Score;

import java.util.List;

public interface ScoreService {
    public void addScore(Score score);
    public List<Score> findByTid(int tid);

}
