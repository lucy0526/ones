package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.DevDao;
import cn.itcast.travel.dao.impl.DevDaoImpl;
import cn.itcast.travel.domain.Dev;
import cn.itcast.travel.service.DevService;

import java.util.List;

public class DevServiceImpl implements DevService {
    DevDao devDao = new DevDaoImpl();

    @Override
    public Dev findByUidAndUid2(int uid, int uid2) {
        Dev dev = null;
        dev = devDao.findByUidAndUid2(uid, uid2);
        if (dev == null)
            dev = devDao.findByUidAndUid2(uid2, uid);
        return dev;
    }

    @Override
    public void addDev(Dev dev) {
        devDao.addDev(dev);
    }

    @Override
    public void updateDev(Dev dev) {
        Dev dev1 = devDao.findByUidAndUid2(dev.getUid1(), dev.getUid2());
        if (dev1 == null)
        {
            int temp = dev.getUid1();
            dev.setUid1(dev.getUid2());
            dev.setUid2(temp);
        }
        devDao.updateDev(dev);
    }

    @Override
    public List<Dev> findByUid(int idUser3) {
        List<Dev> devs = devDao.findByUid(idUser3);
        return devs;
    }

    @Override
    public List<Dev> findAllRelations(int uid) {
        List<Dev> devs = devDao.findAllRelationsByUid(uid);
        return devs;
    }
}
