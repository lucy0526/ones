package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.TestTolImg;

import java.util.List;

public interface TestTolImgDao {
    public List<TestTolImg> findByTid(int tid);
}
