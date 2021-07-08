package com.spring.learning.car_rental_20.service;

import com.spring.learning.car_rental_20.model.Role;
import com.spring.learning.car_rental_20.model.User;
import com.spring.learning.car_rental_20.repos.RoleRepository;
import com.spring.learning.car_rental_20.repos.UserRepository;
import com.spring.learning.car_rental_20.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public User getLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null){
            return null;
        }
        User user = null;
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails){
            user = ((CustomUserDetails) principal).getUser();
        }
        return user;
    }
}
