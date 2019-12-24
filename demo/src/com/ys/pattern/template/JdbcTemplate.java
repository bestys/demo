package com.ys.pattern.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConn() throws SQLException{
        return dataSource.getConnection();
    }

    private PreparedStatement getPreStatement(Connection conn,String sql) throws SQLException{
        return conn.prepareStatement(sql);
    }

    private ResultSet executQury(PreparedStatement preparedStatement,Object[] args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i,args[i]);
        }
        return preparedStatement.executeQuery();
    }

    private List<Object> progessResult(ResultSet rs, RowMapper rowMapper) throws SQLException {
        List<Object> list=  new ArrayList<>();
        int rowNum = 1;
        while (rs.next()){
            list.add(rowMapper.progressResult(rs,rowNum++));
        }
        return list;
    }
    public List<Object> executeSql(String sql, RowMapper rowMapper){
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.创建链接
            conn =  this.getConn();
            // 2.创建语句集
            preStatement = this.getPreStatement(conn, sql);
            // 3.执行语句集，并获得结果
            resultSet = this.executQury(preStatement, null);
            // 4.处理结果集
            return progessResult(resultSet,rowMapper);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                // 5.关闭结果集
                resultSet.close();
                // 6.关闭语句集
                preStatement.close();
                // 7.线程池回收链接
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
