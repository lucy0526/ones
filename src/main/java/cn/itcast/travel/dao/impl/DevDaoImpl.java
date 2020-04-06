package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.DevDao;
import cn.itcast.travel.domain.Dev;
import cn.itcast.travel.domain.TestTol;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DevDaoImpl implements DevDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Dev findByUidAndUid2(int uid, int uid2) {
        Dev dev = null;
        try {
            String sql = "select * from tab_dev where uid1=? and uid2=?";
            dev = template.queryForObject(sql, new BeanPropertyRowMapper<Dev>(Dev.class), uid, uid2);
        } catch (Exception e) {
        }
        return dev;

    }

    @Override
    public void addDev(Dev dev) {
        String sql = "insert into tab_dev values (?,?,?,?)";
        template.update(sql, dev.getUid1(), dev.getUid2(), dev.getDev(), dev.getDev_count());

    }

    @Override
    public void updateDev(Dev dev) {
        String sql = "update tab_dev set dev=?, dev_count=? where uid1=? and uid2=?";
        template.update(sql, dev.getDev(), dev.getDev_count(), dev.getUid1(), dev.getUid2());

    }

    @Override
    public List<Dev> findByUid(int idUser3) {
        List<Dev> devs = null;
        try {
            String sql = "select * from tab_dev where uid1=?";
            devs = template.query(sql, new BeanPropertyRowMapper<Dev>(Dev.class), idUser3);
            if (devs.size() == 0) {
                sql = "select * from tab_dev where uid2=?";
                devs = template.query(sql, new BeanPropertyRowMapper<Dev>(Dev.class), idUser3);
            }
        } catch (Exception e) {
        }
        return devs;
    }

    @Override
    public List<Dev> findAllRelationsByUid(int uid) {
        List<Dev> devs1 = null;
        List<Dev> devs2 = null;
        try {
            String sql = "select * from tab_dev where uid1=?";
            devs1 = template.query(sql, new BeanPropertyRowMapper<Dev>(Dev.class), uid);

            sql = "select * from tab_dev where uid2=?";
            devs2 = template.query(sql, new BeanPropertyRowMapper<Dev>(Dev.class), uid);

            for (Dev dev : devs2)
            {
                devs1.add(dev);
            }

        } catch (Exception e) {
        }
        return devs1;
    }
}
