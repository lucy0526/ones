package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CommonDao;
import cn.itcast.travel.dao.impl.CommonDaoImpl;
import cn.itcast.travel.domain.Common;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.service.CommonService;

import java.util.List;

public class CommonServiceImpl implements CommonService {
    private CommonDao commonDao = new CommonDaoImpl();
    @Override
    public PageBean<Common> pageQuery(int tid, int currentPage, int pageSize) {
        PageBean<Common> pb = new PageBean<Common>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        int totalCount = commonDao.findTotalCount(tid);
        pb.setTotalCount(totalCount);

        int start = (currentPage-1) * pageSize;
        List<Common> list = commonDao.findByPage(tid, start, pageSize);
        pb.setList(list);

        int totalPage = totalCount%pageSize == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
