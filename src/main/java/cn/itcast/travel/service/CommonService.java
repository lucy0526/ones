package cn.itcast.travel.service;

import cn.itcast.travel.domain.Common;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.TestTol;

public interface CommonService {
    PageBean<Common> pageQuery(int tid, int currentPage, int pageSize);
}
