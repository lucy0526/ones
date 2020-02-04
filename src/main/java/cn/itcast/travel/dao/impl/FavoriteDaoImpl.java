package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class FavoriteDaoImpl implements FavoriteDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询收藏次数
     */
    public int findCountByTid(int tid) {
        String sql = "select count(*) from tab_favorite where tid=?";
        return template.queryForObject(sql, Integer.class, tid);
    }

    public Favorite findByTidAndUid(int tid, int uid) {
        Favorite favorite = null;
        try {
            String sql = "select * from tab_favorite where tid=? and uid=?";
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), tid, uid);
        } catch (Exception e) {//防止没有查到，报错
        }
        return favorite;
    }

    public void add(int tid, int uid) {
        String sql = "insert into tab_favorite values(?,?,?)";
        template.update(sql, tid, new Date(), uid);
    }
}
