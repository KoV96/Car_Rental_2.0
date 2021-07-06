package com.spring.learning.car_rental_20.repoTest;

import com.spring.learning.car_rental_20.model.Role;
import com.spring.learning.car_rental_20.model.User;
import com.spring.learning.car_rental_20.repos.RoleRepository;
import com.spring.learning.car_rental_20.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryTest {
    private final User user = new User("Oleksandr", "Kurylyk", "1111", "sanja@gmail.com");

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateRoles(){
        Role user = new Role("User");
        Role loginUser = new Role("Login User");
        Role admin = new Role("Admin");
        List<Role> roles = new ArrayList<>();
        roles.add(user);
        roles.add(loginUser);
        roles.add(admin);
        roleRepository.saveAll(roles);
        List<Role> listRoles = roleRepository.findAll();
        assertThat(listRoles.size()).isEqualTo(3);
    }

    @Test
    public void addRoleToNewUser(){
        Role roleUser = roleRepository.findByName("User");
        user.addRole(roleUser);
        User savedUser = userRepository.save(user);
        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }

    @Test
    public void addRolesToExistUser(){
        User user = userRepository.findByEmail("okurylyk@luxoft.com");
        Role roleUser = roleRepository.findByName("User");
        user.addRole(roleUser);
        Role roleAdmin = roleRepository.findByName("Admin");
        user.addRole(roleAdmin);
        User savedUser = userRepository.save(user);
        assertThat(savedUser.getRoles().size()).isEqualTo(2);
    }
}
