package com.spring.learning.car_rental_20.controller;

import com.spring.learning.car_rental_20.model.Car;
import com.spring.learning.car_rental_20.model.User;
import com.spring.learning.car_rental_20.repos.CarRepository;
import com.spring.learning.car_rental_20.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private CarRepository carRepository;

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
        userService.saveUserWithDefaultRole(user);
        return "register_success";
    }


    @GetMapping("/user_page")
    public String viewUserPage(Model model){
        //model.addAttribute("car", );
        return "user_page";
    }
}
