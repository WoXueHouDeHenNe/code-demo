package com.example.demo.config;

import io.micrometer.common.util.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 字符串数组处理器
 * 将数据库字段中形如 history,chemistry 的字符串转为 ["history", "chemistry"] 形式的集合
 * 对于
 */
public class StringArrayTypeHandler extends BaseTypeHandler<List<String>>  {
    /**
     *
     * @param ps
     * @param i 参数位置
     * @param parameter 参数值
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        if (Objects.isNull(parameter)) {
            return;
        }
        String temp = String.join(",", parameter);
        ps.setString(i, temp);
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String resultSetString = rs.getString(columnName);
        if (StringUtils.isBlank(resultSetString)) {
            return Collections.emptyList();
        }
        return Arrays.asList(resultSetString.trim().split(","));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        String resultSetString = rs.getString(columnIndex);
        if (StringUtils.isBlank(resultSetString)) {
            return Collections.emptyList();
        }
        return Arrays.asList(resultSetString.trim().split(","));
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String resultSetString = cs.getString(columnIndex);
        if (StringUtils.isBlank(resultSetString)) {
            return Collections.emptyList();
        }
        return Arrays.asList(resultSetString.trim().split(","));
    }
}
