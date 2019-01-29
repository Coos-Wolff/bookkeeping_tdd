package com.wolffsoft.bookkeeping.repository;

import com.wolffsoft.bookkeeping.AbstractRepositoryTest;
import com.wolffsoft.bookkeeping.model.User;
import org.jdbi.v3.core.Jdbi;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest extends AbstractRepositoryTest<UserRepository> {

    private User user;

    @Before
    public void setup() {
        user = User.builder()
                .id(1)
                .firstName("Coos")
                .lastName("Wolff")
                .dateOfBirth(LocalDate.of(1983, 2, 11))
                .nickname("AussieBuddy")
                .email("test@email.com")
                .username("cwolff")
                .password("superawesomesecretpassword")
                .build();
    }

    @Override
    protected UserRepository createRepository(Jdbi jdbi) {
        return new UserRepository(jdbi);
    }

    @Test
    public void testGetUserById() {
        int id = 1;

        Optional<User> returnedUser = repo.getById(id);

        assertThat(returnedUser.get()).isEqualTo(user);
    }

    @Test
    public void testGetUserByIdNonExistingId() {
        int nonExistingId = 2147483647;

        Optional<User> nonExistingUser = repo.getById(nonExistingId);

        assertThat(nonExistingUser).isEmpty();
    }

    @Test
    public void testGetUserByEmail() {
        String email = "test@email.com";

        Optional<User> returnedUser = repo.getByEmail(email);

        assertThat(returnedUser.get()).isEqualTo(user);
    }

    @Test
    public void testGetUserByEmailNonExistingEmail() {
        String nonExistingEmail = "NonExistingEmail";

        Optional<User> returnedUser = repo.getByEmail(nonExistingEmail);

        assertThat(returnedUser).isEmpty();
    }
}
