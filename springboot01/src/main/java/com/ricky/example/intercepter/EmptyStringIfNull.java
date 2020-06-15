package com.ricky.example.intercepter;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ricky
 * @create 2020-06-15 11:23
 */
public class EmptyStringIfNull implements TypeHandler<String> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException {
        return (resultSet.getString(s) == null) ? "" : resultSet.getString(s);
    }

    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException {
        return (resultSet.getString(i) == null) ? "" : resultSet.getString(i);
    }

    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        return (callableStatement.getString(i) == null) ? "" : callableStatement.getString(i);
    }
}
