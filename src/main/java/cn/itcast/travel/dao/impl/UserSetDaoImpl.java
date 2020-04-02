package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserSetDao;
import cn.itcast.travel.domain.UserSet;
import cn.itcast.travel.domain.UserSetRecommend;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserSetDaoImpl implements UserSetDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 删除对某个用户的所有推荐
     */
    public void deleteAllByUId(int uid){
        String sql = "delete from tab_user_set where uid=?";
        template.update(sql, uid);
    }

    /**
        更新数据库:
     * 1. 用户推荐表中已经有该用户
     * 2. 用户推荐表中没有该用户
     */
    public void updateRecommendation(int uid, List<UserSet.Set> recommendations){
        deleteAllByUId(uid);//删除旧记录

        //存入每条推荐
        for (UserSet.Set set : recommendations) {
            String sql = "insert into tab_user_set values(?,?,?)";
            template.update(sql, uid, set.tid, set.score);
        }
    }

    public UserSetRecommend findOne(int uid)
    {
        String sql = "select * from tab_user_set where uid=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<UserSetRecommend>(UserSetRecommend.class), uid);
    }

    public int findAllRecommendByUId(int uid){
        String sql = "select * from tab_user_set where uid=?";//order by需要排序的字段名desc
        return template.queryForObject(sql, new BeanPropertyRowMapper<Integer>(Integer.class), uid);
    }
}
