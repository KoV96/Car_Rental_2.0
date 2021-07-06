package com.spring.learning.car_rental_20.repos;

import com.spring.learning.car_rental_20.model.Role;
import com.spring.learning.car_rental_20.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    public Role findByName(String name);
}
