package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Common;
import cn.itcast.travel.domain.TestTol;

import java.util.List;

public interface CommonDao {
    List<Common> findByPage(int tid, int start, int pageSize);
    int findTotalCount(int tid);
}
