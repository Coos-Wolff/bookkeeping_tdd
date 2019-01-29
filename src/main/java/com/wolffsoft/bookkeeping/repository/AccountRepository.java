package com.wolffsoft.bookkeeping.repository;

import com.wolffsoft.bookkeeping.model.Account;
import com.wolffsoft.bookkeeping.repository.mapper.AccountMapper;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountRepository {

    private final Jdbi jdbi;
    private final AccountMapper accountMapper;

    public AccountRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
        this.accountMapper = new AccountMapper();
    }

    public Optional<Account> getById(int id) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM account where id = :id")
                        .bind("id", id)
                        .map(accountMapper)
                        .findFirst()
        );
    }

}
