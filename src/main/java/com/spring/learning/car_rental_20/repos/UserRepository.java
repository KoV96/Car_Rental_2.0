package com.spring.learning.car_rental_20.repos;

import com.spring.learning.car_rental_20.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
