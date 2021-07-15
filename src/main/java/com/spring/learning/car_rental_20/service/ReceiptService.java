package com.spring.learning.car_rental_20.service;

import com.spring.learning.car_rental_20.model.Car;
import com.spring.learning.car_rental_20.model.Receipt;
import com.spring.learning.car_rental_20.repos.ReceiptRepository;
import com.spring.learning.car_rental_20.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private UserRepository userRepository;

    public void updateTotalPrice(Receipt receipt){
        double total = 0;
        for (Car car : receipt.getCars()){
            total += car.getPrice() * receipt.getDays();
        }
        receipt.setTotalPrice(total);
    }

}
