package com.spring.learning.car_rental_20.model;

import com.spring.learning.car_rental_20.repos.CarRepository;
import com.spring.learning.car_rental_20.repos.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddToReceipt {
    private Receipt receipt;
    private CarRepository carRepository;

    public AddToReceipt(Receipt receipt){
        this.receipt = receipt;
    }

    private List<Long> checkedCars;

    public List<Long> getCheckedCars() {
        return checkedCars;
    }

    public void setCheckedCars(List<Long> checkedCars) {
        this.checkedCars = checkedCars;
    }

    public void addCheckedCars(){
        List<Car> cars = carRepository.findAllById(checkedCars);
        receipt.setCars(cars);
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
}
