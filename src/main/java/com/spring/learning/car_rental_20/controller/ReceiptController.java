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
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ReceiptController {

    @Autowired
    private UserService userService;
    @Autowired
    private ReceiptService receiptService;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ReceiptRepository receiptRepository;

    @GetMapping("/receipt")
    public String showUserReceipts(Model model){
        User user = userService.getLoggedInUser();
        model.addAttribute("receipts", user.getReceipts());
        return "receipt";
    }

    @GetMapping("/car_list")
    public String viewCarList(Model model){
        List<Car> allCars = carRepository.findAll();
        model.addAttribute("cars", allCars);
        model.addAttribute("receipt", new Receipt());
        return "car_list";
    }

    @PostMapping("/receipt")
    public String showReservePage(@ModelAttribute Receipt receipt){
        User currentUser = userService.getLoggedInUser();
        receipt.setUser(currentUser);
        currentUser.getReceipts().add(receipt);
        receiptService.updateTotalPrice(receipt);
        receiptRepository.save(receipt);
        return "redirect:receipt";
    }

    // Dose not work. Break frontend view after application start with this method
    /*

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        receiptRepository.deleteById(id);
        User user = userService.getLoggedInUser();
        user.getReceipts().remove(receiptRepository.getById(id));
        return "redirect:receipt";
    }
     */


}
