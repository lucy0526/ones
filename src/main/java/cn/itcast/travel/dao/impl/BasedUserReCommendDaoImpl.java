package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.BasedUserReCommendDao;
import cn.itcast.travel.domain.BasedUserRecommend;
import cn.itcast.travel.domain.TestTol;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BasedUserReCommendDaoImpl implements BasedUserReCommendDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void deleteByUidAndTid(int uid, int tid) {
        String sql = "DELETE FROM tab_basedUser_recommend WHERE uid=? AND tid=?";
        template.update(sql, uid, tid);
    }

    @Override
    public BasedUserRecommend findOneByUidAndTid(int uid, int tid) {
        BasedUserRecommend basedUserRecommend = null;
        try {
            String sql = "select * from tab_basedUser_recommend where uid=? and tid=?";
            basedUserRecommend = template.queryForObject(sql, new BeanPropertyRowMapper<BasedUserRecommend>(BasedUserRecommend.class), uid, tid);
        } catch (Exception e) {
        }
        return basedUserRecommend;
    }

    @Override
    public void updateByUidAndTid(float preScore, int uid, int tid) {
        String sql = "UPDATE tab_basedUser_recommend SET preScore=? WHERE uid=? AND tid=?";
        template.update(sql, preScore, uid, tid);
    }

    @Override
    public void addPreScore(float p, int uid, int tid) {
        String sql = "insert into tab_basedUser_recommend values (?,?,?)";
        template.update(sql, uid, tid, p);
    }

    @Override
    public List<BasedUserRecommend> findByUid(int uid) {
        List<BasedUserRecommend> recommendList = null;
        try {
            String sql = "select * from tab_basedUser_recommend where uid=?";
            recommendList = template.query(sql, new BeanPropertyRowMapper<BasedUserRecommend>(BasedUserRecommend.class), uid);
        } catch (Exception e) {
        }
        return recommendList;
    }
}
