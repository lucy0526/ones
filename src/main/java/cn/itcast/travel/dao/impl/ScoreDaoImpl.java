package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.ScoreDao;
import cn.itcast.travel.domain.Score;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ScoreDaoImpl implements ScoreDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Score> findAll() {
        String sql = "SELECT * FROM tab_score";
        return template.query(sql, new BeanPropertyRowMapper<Score>(Score.class));
    }

    @Override
    public void addScore(Score score) {
        String sql = "insert into tab_score values(?,?,?)";
        template.update(sql, score.getUid(), score.getTid(), score.getScore());
    }

    @Override
    public List<Score> findByTid(int tid) {
        String sql = "SELECT * FROM tab_score where tid=?";
        return template.query(sql, new BeanPropertyRowMapper<Score>(Score.class), tid);
    }
}
