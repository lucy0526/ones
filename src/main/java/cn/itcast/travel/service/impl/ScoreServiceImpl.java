package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.ScoreDao;
import cn.itcast.travel.dao.impl.ScoreDaoImpl;
import cn.itcast.travel.domain.Score;
import cn.itcast.travel.service.ScoreService;

import java.util.List;

public class ScoreServiceImpl implements ScoreService {
    ScoreDao scoreDao = new ScoreDaoImpl();

    @Override
    public List<Score> findByUid(int uid) {
        return scoreDao.findByUid(uid);
    }

    @Override
    public List<Score> findByUidAndTid(int uid, int tid) {
        return scoreDao.findByUidAndTid(uid, tid);
    }

    @Override
    public boolean addScore(Score score) {
        if (findByUidAndTid(score.getUid(), score.getTid()).size() == 0){
            scoreDao.addScore(score);
            return true;
        }else
            return false;
    }

    @Override
    public List<Score> findByTid(int tid) {
        return scoreDao.findByTid(tid);
    }
}
