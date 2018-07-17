package com.wolffsoft.bookkeeping.config;

import org.skife.jdbi.v2.DBI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBIConfig {

    @Bean
    public DBI dbi(DataSource dataSource) {
        return new DBI(dataSource);
    }
}
