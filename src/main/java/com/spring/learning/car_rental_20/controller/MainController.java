package com.spring.learning.car_rental_20.controller;

import com.spring.learning.car_rental_20.model.User;
import com.spring.learning.car_rental_20.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String homePage(){
        return "home";
    }

    @GetMapping("/register")
    public String registrationPage(Model model){
        model.addAttribute("user", new User());
        return "register_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        userRepository.save(user);
        return "register_success";
    }

    // TODO Add more functionality ....
    @GetMapping("/user_page")
    public String viewUserPage(Model model){
        return "user_page";
    }
}
