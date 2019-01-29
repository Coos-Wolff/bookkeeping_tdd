package com.wolffsoft.bookkeeping;

import com.google.common.base.Charsets;
import org.flywaydb.core.Flyway;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.junit.Before;

import java.io.InputStreamReader;

public abstract class AbstractRepositoryTest<RepositoryType> {
    public RepositoryType repo;
    private Jdbi jdbi;

    protected abstract RepositoryType createRepository(Jdbi jdbi);

    @Before
    public void setupFlyway() throws Exception {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUser("SA");
        dataSource.setPassword("");
        dataSource.setURL("jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_DELAY=-1L;");

        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setSchemas("PUBLIC");
        flyway.setLocations("/db/migration/test");
        flyway.migrate();

        jdbi = Jdbi.create(dataSource);

        runDbScript("/init_test.sql");
        runDbScript("/user_data.sql");
        runDbScript("/account_data.sql");

        repo = createRepository(jdbi);
    }

    private void runDbScript(final String scriptPath) throws Exception {
        try (InputStreamReader reader = new InputStreamReader(AbstractRepositoryTest.class.getResourceAsStream(scriptPath),
                Charsets.UTF_8); Handle h = jdbi.open()) {
            RunScript.execute(h.getConnection(), reader);
        }
    }
}
