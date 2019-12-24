package com.ys.pattern.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface RowMapper<T> {
    public List<T> progressResult(ResultSet rs,int rowNum) throws SQLException;
}
