package com.wolffsoft.bookkeeping.repository;

import com.wolffsoft.bookkeeping.model.User;
import com.wolffsoft.bookkeeping.repository.mapper.UserMapper;
import org.skife.jdbi.v2.DBI;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final DBI dbi;
    private final UserMapper userMapper;

    public UserRepository(DBI dbi) {
        this.dbi = dbi;
        this.userMapper = new UserMapper();
    }

    public User getById(Integer id) {
        return dbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM user where id = :id")
                .bind("id", id)
                .map(userMapper)
                .first()
        );
    }
}
