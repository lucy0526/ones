package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.ScoreDao;
import cn.itcast.travel.dao.impl.ScoreDaoImpl;
import cn.itcast.travel.domain.Score;
import cn.itcast.travel.service.ScoreService;

import java.util.List;

public class ScoreServiceImpl implements ScoreService {
    ScoreDao scoreDao = new ScoreDaoImpl();
    @Override
    public void addScore(Score score) {
        scoreDao.addScore(score);
    }

    @Override
    public List<Score> findByTid(int tid) {
        return scoreDao.findByTid(tid);
    }
}
