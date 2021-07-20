package com.spring.learning.car_rental_20.controller;

import com.spring.learning.car_rental_20.model.Car;
import com.spring.learning.car_rental_20.model.Receipt;
import com.spring.learning.car_rental_20.model.User;
import com.spring.learning.car_rental_20.repos.CarRepository;
import com.spring.learning.car_rental_20.repos.ReceiptRepository;
import com.spring.learning.car_rental_20.service.ReceiptService;
import com.spring.learning.car_rental_20.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private ReceiptService receiptService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/register")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user) {
        userService.saveUserWithDefaultRole(user);
        return "register_success";
    }

    @GetMapping("/user_page")
    public String viewUserPage() {
        return "user_page";
    }

    @GetMapping("/car_list")
    public String viewCarList(Model model) {
        List<Car> allCars = carRepository.findAll();
        model.addAttribute("cars", allCars);
        model.addAttribute("receipt", new Receipt());
        return "car_list";
    }

    @GetMapping("/receipt_list")
    public String showUserReceipts(Model model) {
        User user = userService.getLoggedInUser();
        model.addAttribute("receipts", user.getReceipts());
        return "receipt_list";
    }

    @PostMapping("/receipt_list")
    public String addToReceipt(@ModelAttribute Receipt receipt) {
        User currentUser = userService.getLoggedInUser();
        receipt.setUser(currentUser);
        currentUser.getReceipts().add(receipt);
        receiptService.updateTotalPrice(receipt);
        receiptRepository.save(receipt);
        return "redirect:receipt_list";
    }

    @GetMapping("/403")
    public String errorAccess() {
        return "403";
    }
}
