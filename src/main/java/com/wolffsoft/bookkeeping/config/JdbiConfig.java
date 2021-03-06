package com.wolffsoft.bookkeeping.config;

import org.jdbi.v3.core.Jdbi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbiConfig {

    @Bean
    public Jdbi dbi(DataSource dataSource) {
        return Jdbi.create(dataSource);
    }
}
