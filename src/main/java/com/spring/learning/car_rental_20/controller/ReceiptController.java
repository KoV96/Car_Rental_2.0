package com.spring.learning.car_rental_20.controller;

import com.spring.learning.car_rental_20.model.Receipt;
import com.spring.learning.car_rental_20.model.User;
import com.spring.learning.car_rental_20.repos.CarRepository;
import com.spring.learning.car_rental_20.repos.ReceiptRepository;
import com.spring.learning.car_rental_20.service.ReceiptService;
import com.spring.learning.car_rental_20.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private UserService userService;
    @Autowired
    private ReceiptService receiptService;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ReceiptRepository receiptRepository;

    @GetMapping()
    public List<Receipt> showUserReceipts(Model model) {
        return receiptRepository.findAll();
    }



    @GetMapping("/{id}")
    public Receipt showReceiptDetails(@PathVariable("id") Long id) {
        return receiptRepository.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        receiptRepository.deleteReceipt(id);
        response.sendRedirect("/receipt_list");
    }
}
