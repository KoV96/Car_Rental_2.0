package com.spring.learning.car_rental_20.repoTest;

import com.spring.learning.car_rental_20.model.User;
import com.spring.learning.car_rental_20.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    private final User user = new User("Oleksandr", "Kurylyk", "1111", "sanja@gmail.com");

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createUserTest(){
        User savedUser = userRepository.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void findUserByEmail(){
        userRepository.save(user);
        User foundUser = userRepository.findByEmail(user.getEmail());
        assertThat(foundUser.getEmail()).isEqualTo(user.getEmail());
    }
}