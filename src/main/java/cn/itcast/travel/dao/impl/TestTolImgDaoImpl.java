package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.TestTolImgDao;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.TestTolImg;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TestTolImgDaoImpl implements TestTolImgDao {
    private JdbcTemplate template = new JdbcTemplate((JDBCUtils.getDataSource()));
    public List<TestTolImg> findByTid(int tid){
        String sql = "select * from tab_test_img where tid=?";
        return template.query(sql, new BeanPropertyRowMapper<TestTolImg>(TestTolImg.class), tid);
    }
}
