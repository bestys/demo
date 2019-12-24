package com.ys.pattern.template.Dao;

import com.ys.pattern.template.JdbcTemplate;
import com.ys.pattern.template.RowMapper;
import com.ys.pattern.template.entity.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private JdbcTemplate jdbcTemplate;
    public List<?> query(){
        String sql = "select * from t_user";
        return jdbcTemplate.executeSql(sql, new RowMapper<Entity>() {
            List result = new ArrayList();
            @Override
            public List<Entity> progressResult(ResultSet rs,int rowNum) throws SQLException {
                Entity entity = new Entity();
                entity.setName(rs.getString(1));
                entity.setAge(rs.getString(2));
                result.add(entity);
                return result;
            }
        });
    }
}
