package com.wolffsoft.bookkeeping.model;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;

import java.time.LocalDate;

@AutoValue
public abstract class User {

    // User only the create method. This has preconditions the builder has not.
    public static User create(int id, String firstName, String lastName, LocalDate dateOfBirth, String nickname,
                              String email, String username, String password) {
        Preconditions.checkArgument(id >= 1, "Id cannot be smaller than 1");
        Preconditions.checkArgument(!email.isEmpty(), "Email cannot be empty");
        Preconditions.checkArgument(!username.isEmpty(), "Username cannot be empty");
        Preconditions.checkArgument(!password.isEmpty(), "Password cannot be empty");

        return User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(dateOfBirth)
                .nickname(nickname)
                .email(email)
                .username(username)
                .password(password)
                .build();
    }

    public abstract Integer getId();

    public abstract String getFirstName();

    public abstract String getLastName();

    public abstract LocalDate getDateOfBirth();

    public abstract String getNickname();

    public abstract String getEmail();

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

        public abstract Builder email(String email);

        public abstract Builder username(String username);

        public abstract Builder password(String password);

        public abstract User build();
    }
}
