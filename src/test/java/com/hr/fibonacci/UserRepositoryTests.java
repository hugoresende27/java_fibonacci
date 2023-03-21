package com.hr.fibonacci;

import com.hr.fibonacci.models.User;
import com.hr.fibonacci.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //tu use real DB
@Rollback(value = false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("hugo@hugo");
        user.setPassword("12345678");
        user.setFirstName("hugo");
        user.setLastName("Resende");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        Assertions.assertThat(existUser.getEmail()).isEqualTo(user.getEmail());

    }

    @Test
    public void testFindUserByEmail(){
        String email = "hugo@hugo";

        User user = repo.findByEmail(email);

        Assertions.assertThat(user).isNotNull();
    }

}
