package com.spring.learning.car_rental_20.repoTest;

import com.spring.learning.car_rental_20.model.Car;
import com.spring.learning.car_rental_20.repos.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createCarTest(){
        Car car = new Car("Toyota", "Rav-4", "2016", 180.0, 70.0);
        Car savedCar = carRepository.save(car);
        Car existCar = entityManager.find(Car.class, savedCar.getId());
        assertThat(existCar.getCarModel()).isEqualTo(car.getCarModel());
    }
}
