package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.BasedUserReCommendDao;
import cn.itcast.travel.dao.impl.BasedUserReCommendDaoImpl;
import cn.itcast.travel.domain.BasedUserRecommend;
import cn.itcast.travel.service.BasedUserReCommendService;

import java.util.List;

public class BasedUserReCommendServiceImpl implements BasedUserReCommendService {
    private BasedUserReCommendDao basedUserReCommendDao = new BasedUserReCommendDaoImpl();

    @Override
    public void deleteByUidAndTid(int uid, int tid) {
        basedUserReCommendDao.deleteByUidAndTid(uid, tid);
    }

    @Override
    public boolean hadPreScore(int uid, int tid) {
        BasedUserRecommend basedUserRecommend = basedUserReCommendDao.findOneByUidAndTid(uid, tid);
        if (basedUserRecommend != null)
            return true;
        else
            return false;
    }

    @Override
    public void updateByUidAndTid(float preScore, int uid, int tid) {
        basedUserReCommendDao.updateByUidAndTid(preScore, uid, tid);
    }

    @Override
    public void addPreScore(float p, int uid, int tid) {
        basedUserReCommendDao.addPreScore(p, uid, tid);
    }

    @Override
    public List<BasedUserRecommend> findByUid(int uid) {
        return basedUserReCommendDao.findByUid(uid);
    }
}
