package com.spring.learning.car_rental_20.controller;


import com.spring.learning.car_rental_20.model.Car;
import com.spring.learning.car_rental_20.repos.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/add_car")
    public String addCar(Model model){
        model.addAttribute("newCar", new Car());
        return "add_car";
    }

    @PostMapping("/adding_car")
    public String addingCar(Car car){
        carRepository.save(car);
        return "redirect:/car_list";
    }
}
