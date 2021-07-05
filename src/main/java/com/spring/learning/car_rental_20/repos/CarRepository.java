package com.spring.learning.car_rental_20.repos;

import com.spring.learning.car_rental_20.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
