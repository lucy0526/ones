package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.BasedUserReCommendDao;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class BasedUserReCommendDaoImpl implements BasedUserReCommendDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void deleteByUidAndTid(int uid, int tid) {
        String sql = "DELETE FROM tab_basedUser_recommend WHERE uid=? AND tid=?";
        template.update(sql, uid, tid);
    }
}
