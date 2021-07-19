package com.spring.learning.car_rental_20.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private Long id;
    @Column(name = "car_brand")
    private String carBrand;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "year")
    private String year;
    @Column(name = "power")
    private Double power;
    @Column(name = "price_per_day")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Car(String carBrand, String carModel, String year, Double power, Double price) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.year = year;
        this.power = power;
        this.price = price;
    }

    public Car(String carBrand, String carModel, String year, Double power, Double price, Integer quantity) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.year = year;
        this.power = power;
        this.price = price;
        this.quantity = quantity;
    }

    public Car() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }
}
