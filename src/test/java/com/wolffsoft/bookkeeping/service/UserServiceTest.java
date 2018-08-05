package com.wolffsoft.bookkeeping.service;

import com.wolffsoft.bookkeeping.model.User;
import com.wolffsoft.bookkeeping.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private static final Integer ID = 1;
    private static final String FIRST_NAME = "Coos";
    private static final String LAST_NAME = "Wolff";
    private static final String NICKNAME = "AussieBuddy";
    private static final String EMAIL = "test@email.com";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final LocalDate DATE_OF_BIRTH = LocalDate.of(1983, 2, 11);

    private User user;
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setup() {
        userService = new UserService(userRepository);
        user = User.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .dateOfBirth(DATE_OF_BIRTH)
                .nickname(NICKNAME)
                .email(EMAIL)
                .username(USERNAME)
                .password(PASSWORD)
                .build();
    }

    @Test
    public void testGetUserById() {
        when(userRepository.getById(1)).thenReturn(Optional.of(user));

        Optional<User> returnedUser = userService.getById(1);

       assertThat(returnedUser).isEqualTo(user);
    }

    @Test
    public void testGetUserByEmail() {
        when(userRepository.getByEmail(EMAIL)).thenReturn(Optional.of(user));

        Optional<User> returnedUser = userService.getByEmail(EMAIL);

        assertThat(returnedUser).isEqualTo(user);
    }
}
