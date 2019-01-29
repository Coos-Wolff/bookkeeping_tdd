package com.wolffsoft.bookkeeping.repository;

import com.wolffsoft.bookkeeping.AbstractRepositoryTest;
import com.wolffsoft.bookkeeping.model.Account;
import org.jdbi.v3.core.Jdbi;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AccountRepositoryTest extends AbstractRepositoryTest<AccountRepository> {

    private Account account;

    @Before
    public void setup() {
        account = Account.builder()
                .id(1)
                .userId(1)
                .accountNumber("NL41ABNA0123456789")
                .balance(new BigDecimal(12.34).setScale(2, RoundingMode.CEILING))
                .build();
    }

    @Override
    protected AccountRepository createRepository(Jdbi jdbi) {
        return new AccountRepository(jdbi);
    }

    @Test
    public void testGetById() {
        int id = 1;

        Optional<Account> returnedAccount =  repo.getById(id);

        assertThat(returnedAccount.get()).isEqualTo(account);
    }


}
