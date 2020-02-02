package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.TestTol;

import java.util.List;

public interface TestTolDao {
    List<TestTol> findNewest();

    List<TestTol> findPopularity();


    int findTotalCount(int cid, String tname);

    List<TestTol> findByPage(int cid, int start, int pageSize, String tname);

    TestTol findOne(int parseInt);
}
