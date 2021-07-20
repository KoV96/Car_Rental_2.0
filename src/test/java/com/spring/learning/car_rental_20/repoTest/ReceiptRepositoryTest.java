package com.spring.learning.car_rental_20.repoTest;

import com.spring.learning.car_rental_20.model.Car;
import com.spring.learning.car_rental_20.model.Receipt;
import com.spring.learning.car_rental_20.model.User;
import com.spring.learning.car_rental_20.repos.ReceiptRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReceiptRepositoryTest {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createReceiptTest(){
        User user = new User("Oleksandr", "Kurylyk", "1111", "sanja@gmail.com");
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("Toyota", "Rav-4", "2016", 180.0, 70.0));
        Receipt receipt = new Receipt(user, cars, 5);
        Receipt savedReceipt = receiptRepository.save(receipt);
        Receipt existReceipt = entityManager.find(Receipt.class, savedReceipt.getId());
        assertThat(existReceipt.getUser()).isEqualTo(receipt.getUser());
    }
}
