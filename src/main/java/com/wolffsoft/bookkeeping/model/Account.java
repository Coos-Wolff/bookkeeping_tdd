package com.wolffsoft.bookkeeping.model;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;

import java.math.BigDecimal;

@AutoValue
public abstract class Account {

    // User only the create method. This has preconditions the builder has not.
    public static Account create(int id, int userId, String accountNumber, BigDecimal balance) {
        Preconditions.checkArgument(id >= 1, "Id cannot be smaller than 1");
        Preconditions.checkArgument(userId >= 1, "User id cannot be smaller than 1");
        Preconditions.checkArgument(!accountNumber.isEmpty(), "Account number cannot be empty");
        Preconditions.checkNotNull(balance, "Balance cannot be null");

        return Account.builder()
                .id(id)
                .userId(userId)
                .accountNumber(accountNumber)
                .balance(balance)
                .build();
    }

    public abstract int getId();

    public abstract int getUserId();

    public abstract String getAccountNumber();

    public abstract BigDecimal getBalance();

    public static Builder builder() {
        return new AutoValue_Account.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder id(int id);

        public abstract Builder userId(int userId);

        public abstract Builder accountNumber(String accountNumber);

        public abstract Builder balance(BigDecimal balance);

        public abstract Account build();
    }
}
