package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.TestTolDao;
import cn.itcast.travel.dao.TestTolImgDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.TestTolDaoImpl;
import cn.itcast.travel.dao.impl.TestTolImgDaoImpl;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.TestTolService;

import java.util.List;

public class TestTolServiceImpl implements TestTolService {
    private TestTolDao testTolDao = new TestTolDaoImpl();
    private TestTolImgDao testTolImgDao = new TestTolImgDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public List<TestTol> findNewest() {
        return testTolDao.findNewest();
    }
    @Override
    public List<TestTol> findPopularity() {
        return testTolDao.findPopularity();
    }

    @Override
    public PageBean<TestTol> pageQuery(int cid, int currentPage, int pageSize, String tname) {
        PageBean<TestTol> pb = new PageBean<TestTol>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        int totalCount = testTolDao.findTotalCount(cid, tname);
        pb.setTotalCount(totalCount);

        int start = (currentPage-1) * pageSize;
        List<TestTol> list = testTolDao.findByPage(cid, start, pageSize, tname);
        pb.setList(list);

        int totalPage = totalCount%pageSize == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public TestTol findOne(String tid) {
        TestTol testTol = testTolDao.findOne(Integer.parseInt(tid));
        List<TestTolImg> testTolImgList = testTolImgDao.findByTid(testTol.getTid());
        testTol.setTestTolImgList(testTolImgList);
        int count = favoriteDao.findCountByRid(testTol.getTid());
        testTol.setCount(count);

        return testTol;
    }
}
