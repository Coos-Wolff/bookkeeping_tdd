package com.wolffsoft.bookkeeping.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {

    private static final int ACCOUNT_ID = 1;
    private static final int USER_ID = 1;
    private static final String ACCOUNT_NUMBER = "NL11ABNA0123456789";
    private static final BigDecimal BALANCE = new BigDecimal("12.34");

    @Test
    public void testPreconditionNoException() {
        Account account = Account.create(ACCOUNT_ID, USER_ID, ACCOUNT_NUMBER, BALANCE);

        assertThat(account.getId()).isEqualTo(ACCOUNT_ID);
        assertThat(account.getUserId()).isEqualTo(USER_ID);
        assertThat(account.getAccountNumber()).isEqualTo(ACCOUNT_NUMBER);
        assertThat(account.getBalance()).isEqualTo(BALANCE);
    }

    @Test
    public void testPreconditionBalanceWithNullValueThrowsException() {
        assertThatThrownBy(() -> Account.create(ACCOUNT_ID, USER_ID, ACCOUNT_NUMBER, null)).hasMessage("Balance " +
                "cannot be null").isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testPreconditionAccountIdThrowsException() {
        assertThatThrownBy(() -> Account.create(0, USER_ID, ACCOUNT_NUMBER, BALANCE)).hasMessage("Id cannot be smaller than 1").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testPreconditionUserIdThrowsException() {
        assertThatThrownBy(() -> Account.create(ACCOUNT_ID, 0, ACCOUNT_NUMBER, BALANCE)).hasMessage("User id cannot be smaller than 1").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testPreconditionAccountNumberThrowsException() {
        assertThatThrownBy(() -> Account.create(ACCOUNT_ID, USER_ID, "", BALANCE)).hasMessage("Account number cannot be empty").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testPreconditionBalanceThrowsException() {
        assertThatThrownBy(() -> Account.create(ACCOUNT_ID, USER_ID, ACCOUNT_NUMBER, null)).hasMessage("Balance " +
                "cannot be null").isInstanceOf(NullPointerException.class);
    }
}
