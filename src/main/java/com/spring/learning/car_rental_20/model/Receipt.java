package com.spring.learning.car_rental_20.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "receipts")
public class Receipt {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "receipt")
    private List<Car> cars;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "receipt_id")
    private Long id;
    @Column(name = "number_of_days")
    private Integer days;
    @Column(name = "total_price")
    private Double totalPrice;

    public Receipt(User user, List<Car> cars, Integer days) {
        this.user = user;
        this.cars = cars;
        this.days = days;
    }

    public Receipt(User user, List<Car> cars) {
        this.user = user;
        this.cars = cars;
    }

    public Receipt(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getTotalPrice() {
        if(cars.size() != 0) {
            for (Car car : cars) {
                totalPrice += car.getPrice();
            }
            return totalPrice * days;
        }
        return 0.0;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
