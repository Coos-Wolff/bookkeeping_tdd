package com.wolffsoft.bookkeeping.model;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    private static final Integer ID = 1;
    private static final String FIRST_NAME = "Coos";
    private static final String LAST_NAME = "Wolff";
    private static final String NICKNAME = "AussieBuddy";
    private static final String EMAIL = "test@email.com";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final LocalDate DATE_OF_BIRTH = LocalDate.of(1983, 2, 11);


    @Test
    public void testPreconditionsNoExceptionsThrownBuilder() {
        User user = User.builder()
                .id(1)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .dateOfBirth(DATE_OF_BIRTH)
                .nickname(NICKNAME)
                .email(EMAIL)
                .username(USERNAME)
                .password(PASSWORD)
                .build();

        assertThat(user.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(user.getLastName()).isEqualTo(LAST_NAME);
        assertThat(user.getDateOfBirth()).isEqualTo(DATE_OF_BIRTH);
        assertThat(user.getNickname()).isEqualTo(NICKNAME);
        assertThat(user.getEmail()).isEqualTo(EMAIL);
        assertThat(user.getUsername()).isEqualTo(USERNAME);
        assertThat(user.getPassword()).isEqualTo(PASSWORD);
    }

    @Test
    public void testPreconditionsNoExceptionsThrownCreate() {
        User user = User.create(ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, NICKNAME, EMAIL, USERNAME, PASSWORD);

        assertThat(user.getId()).isEqualTo(ID);
        assertThat(user.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(user.getLastName()).isEqualTo(LAST_NAME);
        assertThat(user.getDateOfBirth()).isEqualTo(DATE_OF_BIRTH);
        assertThat(user.getNickname()).isEqualTo(NICKNAME);
        assertThat(user.getEmail()).isEqualTo(EMAIL);
        assertThat(user.getUsername()).isEqualTo(USERNAME);
        assertThat(user.getPassword()).isEqualTo(PASSWORD);
    }

    @Test
    public void testPreconditionUsernameThrowsException() {
        assertThatThrownBy(() -> User.create(ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, NICKNAME,  EMAIL, "",
                PASSWORD)).hasMessage("Username cannot be empty").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testPreconditionPasswordThrowsException() {
        assertThatThrownBy(() -> User.create(ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, NICKNAME, USERNAME, EMAIL,
                "")).hasMessage("Password cannot be empty").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testPreconditionIdThrowsException() {
        assertThatThrownBy(() -> User.create(0, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, NICKNAME, USERNAME, EMAIL,
                PASSWORD)).hasMessage("Id cannot be smaller than 1 or be null").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testPreconditionEmailThrowsException() {
        assertThatThrownBy(() -> User.create(1, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, NICKNAME, "", USERNAME,
                PASSWORD)).hasMessage("Email cannot be empty").isInstanceOf(IllegalArgumentException.class);
    }
}
