package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.TestTolDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.TestTol;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class TestTolDaoImpl implements TestTolDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<TestTol> findNewest() {
//        String sql = " select * from tab_test_tol order by STR_TO_DATE(tdate,'%m/%d/%Y %h:%i:%s %p') desc; "
        String sql = "SELECT * FROM tab_test_tol ORDER BY tid DESC LIMIT 4";
        return template.query(sql, new BeanPropertyRowMapper<TestTol>(TestTol.class));
    }
    @Override
    public List<TestTol> findPopularity() {
        String sql = "SELECT * FROM tab_test_tol ORDER BY COUNT DESC LIMIT 4";
        return template.query(sql, new BeanPropertyRowMapper<TestTol>(TestTol.class));
    }

    @Override
    public int findTotalCount(int cid, String tname) {
        String sql = "select count(*) from tab_test_tol where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        if (cid != 0) {
            sb.append(" and cid=?");
            params.add(cid);
        }
        
        if (tname != null && tname.length() > 0) {
            sb.append(" and tname like ?");
            params.add("%"+ tname +"%");
        }
        sql = sb.toString();
        //查询单条纪录
        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<TestTol> findByPage(int cid, int start, int pageSize, String tname) {
        String sql = "select * from tab_test_tol where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        if (cid != 0) {
            sb.append(" and cid=?");
            params.add(cid);
        }
        if (tname != null && tname.length() > 0) {
            sb.append(" and tname like ?");
            params.add("%"+ tname +"%");
        }
        sb.append(" limit ?,?");//分页
        params.add(start);
        params.add(pageSize);
        sql = sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<TestTol>(TestTol.class), params.toArray());

    }

    @Override
    public TestTol findOne(int tid) {
        String sql = "select * from tab_test_tol where tid=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<TestTol>(TestTol.class), tid);
    }

}
