package com.spring.learning.car_rental_20.repos;

import com.spring.learning.car_rental_20.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

}
