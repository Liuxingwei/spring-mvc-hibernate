package cn.liuxingwei.spring.mvc.maven.data;

import cn.liuxingwei.spring.mvc.maven.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void jdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(long spittleId) {
        return null;
    }

    @Override
    public long createSpittle(final Spittle spittle) {
        int id = 1;
        final String sql = "INSERT INTO `t_spittle` (`message`, `time`, `longtude`, `latitude`) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, spittle.getMessage());
                ps.setDate(2, spittle.getTime());
                ps.setDouble(3, spittle.getLongitude());
                ps.setDouble(4, spittle.getLatitude());
                return ps;
            }
        }, keyHolder);
        spittle.setId(keyHolder.getKey().longValue());
        return spittle.getId();
    }
}
