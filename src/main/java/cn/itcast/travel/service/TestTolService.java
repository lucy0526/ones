package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.TestTol;

import java.util.List;

public interface TestTolService {
    List<TestTol> findNewest();
    List<TestTol> findPopularity();

    PageBean<TestTol> pageQuery(int cid, int currentPage, int pageSize, String tname);
    PageBean<TestTol> findByOrderPopAndPage(int currentPage, int pageSize);

    TestTol findOne(String tid);
}
