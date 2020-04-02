package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CommonDao;
import cn.itcast.travel.domain.Common;
import cn.itcast.travel.domain.TestTol;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class CommonDaoImpl implements CommonDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Common> findByPage(int tid, int start, int pageSize) {
        String sql = "select * from tab_common where tid=? limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<Common>(Common.class), tid, start, pageSize);

    }

    @Override
    public int findTotalCount(int tid) {
        String sql = "select count(*) from tab_common where tid=?";
        return template.queryForObject(sql, Integer.class, tid);
    }

}
