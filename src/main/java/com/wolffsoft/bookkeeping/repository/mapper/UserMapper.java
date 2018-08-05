package com.wolffsoft.bookkeeping.repository.mapper;

import com.wolffsoft.bookkeeping.model.User;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet resultSet, StatementContext context) throws SQLException {
        return User.builder()
                .id(resultSet.getInt("id"))
                .firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name"))
                .dateOfBirth(resultSet.getDate("date_of_birth").toLocalDate())
                .nickname(resultSet.getString("nickname"))
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .build();
    }
}
