package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.BasedUserReCommendDao;
import cn.itcast.travel.dao.impl.BasedUserReCommendDaoImpl;
import cn.itcast.travel.service.BasedUserReCommendService;

public class BasedUserReCommendServiceImpl implements BasedUserReCommendService {
    private BasedUserReCommendDao basedUserReCommendDao = new BasedUserReCommendDaoImpl();

    @Override
    public void deleteByUidAndTid(int uid, int tid) {
        basedUserReCommendDao.deleteByUidAndTid(uid, tid);
    }
}
