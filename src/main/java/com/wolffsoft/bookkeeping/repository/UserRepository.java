package com.wolffsoft.bookkeeping.repository;

import com.wolffsoft.bookkeeping.model.User;
import com.wolffsoft.bookkeeping.repository.mapper.UserMapper;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    private final Jdbi jdbi;
    private final UserMapper userMapper;

    public UserRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
        this.userMapper = new UserMapper();
    }

    public Optional<User> getById(Integer id) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM user where id = :id")
                        .bind("id", id)
                        .map(userMapper)
                        .findFirst()
        );
    }

    public Optional<User> getByEmail(String email) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM user where email = :email")
                        .bind("email", email)
                        .map(userMapper)
                        .findFirst()
        );
    }
}
