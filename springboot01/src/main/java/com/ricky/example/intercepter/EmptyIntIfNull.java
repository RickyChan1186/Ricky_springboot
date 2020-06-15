package com.ricky.example.intercepter;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ricky
 * @create 2020-06-15 14:23
 */
public class EmptyIntIfNull implements TypeHandler<Integer> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Integer integer, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Integer getResult(ResultSet resultSet, String s) throws SQLException {
        return (resultSet.getInt(s) == 0) ? 0 : resultSet.getInt(s);
    }

    @Override
    public Integer getResult(ResultSet resultSet, int i) throws SQLException {
        return (resultSet.getInt(i) == 0) ? 0 : resultSet.getInt(i);
    }

    @Override
    public Integer getResult(CallableStatement callableStatement, int i) throws SQLException {
        return (callableStatement.getInt(i) == 0) ? 0 : callableStatement.getInt(i);
    }
}
