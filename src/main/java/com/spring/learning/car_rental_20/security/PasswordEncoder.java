package com.spring.learning.car_rental_20.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "1111";
        System.out.println(passwordEncoder.encode(password));
    }
}
