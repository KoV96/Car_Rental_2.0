package com.spring.learning.car_rental_20.controller;

import com.spring.learning.car_rental_20.service.AddToReceipt;
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
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
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
    public String showUserReceipt(Model model){
        User user = userService.getLoggedInUser();
        model.addAttribute("receipt list", user.getReceipts());
        return "receipt";
    }

    @GetMapping("/car_list")
    public String viewCarList(Model model){
        User currentUser = userService.getLoggedInUser();
        List<Car> allCars = carRepository.findAll();
        List<Car> reservedCars = new LinkedList<>();
        model.addAttribute("cars", allCars);
       // model.addAttribute("receipt", );
        model.addAttribute("addToRe", new AddToReceipt(new Receipt(currentUser, reservedCars)));
        return "car_list";
    }

    @PostMapping("/car_list")
    public String showReservePage(AddToReceipt addToReceipt){
        addToReceipt.addCheckedCars();
        System.out.println(addToReceipt.getReceipt().getCars());
        return "receipt";
    }
}
