package com.wolffsoft.bookkeeping.repository.mapper;

import com.wolffsoft.bookkeeping.model.Account;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {

    @Override
    public Account map(ResultSet resultSet, StatementContext context) throws SQLException {
        return Account.builder()
                .id(resultSet.getInt("id"))
                .userId(resultSet.getInt("user_id"))
                .accountNumber(resultSet.getString("account_number"))
                .balance(resultSet.getBigDecimal("balance"))
                .build();
    }
}
