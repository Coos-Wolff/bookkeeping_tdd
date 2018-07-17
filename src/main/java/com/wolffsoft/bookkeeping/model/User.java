package com.wolffsoft.bookkeeping.model;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;

import java.time.LocalDate;

@AutoValue
public abstract class User {

    public static User create(Integer id, String firstName, String lastName, LocalDate dateOfBirth, String nickname,
                              String username, String password) {
        Preconditions.checkArgument(id == null || (id >= 1), "Id cannot be smaller than 1 or be null");
        Preconditions.checkArgument(!"".equals(username), "Username cannot be empty");
        Preconditions.checkArgument(!"".equals(password), "Password cannot be empty");

        return User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(dateOfBirth)
                .nickname(nickname)
                .username(username)
                .password(password)
                .build();
    }

    public abstract Integer getId();

    public abstract String getFirstName();

    public abstract String getLastName();

    public abstract LocalDate getDateOfBirth();

    public abstract String getNickname();

    public abstract String getUsername();

    public abstract String getPassword();

    public static Builder builder() {
        return new AutoValue_User.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder id(Integer id);

        public abstract Builder firstName(String firstName);

        public abstract Builder lastName(String lastName);

        public abstract Builder dateOfBirth(LocalDate dateOfBirth);

        public abstract Builder nickname(String nickname);

        public abstract Builder username(String username);

        public abstract Builder password(String password);

        public abstract User build();
    }
}
