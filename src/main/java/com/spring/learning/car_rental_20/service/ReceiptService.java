package com.spring.learning.car_rental_20.service;

import com.spring.learning.car_rental_20.model.Car;
import com.spring.learning.car_rental_20.model.Receipt;
import com.spring.learning.car_rental_20.model.User;
import com.spring.learning.car_rental_20.repos.ReceiptRepository;
import com.spring.learning.car_rental_20.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private UserRepository userRepository;

    public void addCarToReceipt(Car car, User user, int quantity, int days) {
        if (car.getQuantity() < quantity) {
            throw new IllegalArgumentException();
        }
        Receipt newReceipt = new Receipt();
        newReceipt.setDays(days);
        newReceipt.getCars().add(car);
        user.getReceipts().add(newReceipt);
    }

    public void removeCarFromReceipt(Car car, User user) {
        Receipt currentReceipt = car.getReceipt();
        List<Car> receiptCars = currentReceipt.getCars();
        if (receiptCars.size() < 2) {
            user.getReceipts().remove(currentReceipt);
        } else {
            receiptCars.remove(car);
        }
    }
}
