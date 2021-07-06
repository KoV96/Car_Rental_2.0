package com.spring.learning.car_rental_20.controller;

import com.spring.learning.car_rental_20.model.Role;
import com.spring.learning.car_rental_20.model.User;
import com.spring.learning.car_rental_20.repos.RoleRepository;
import com.spring.learning.car_rental_20.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public void saveUserWithDefaultRole(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        Role roleUser = roleRepository.findByName("User");
        user.addRole(roleUser);
        userRepository.save(user);
    }
}
