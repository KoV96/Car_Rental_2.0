package com.spring.learning.car_rental_20.controller;

import com.spring.learning.car_rental_20.model.Car;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("admin@admin.com")
@TestPropertySource(value = "/application-test.properties")
@Sql(value = {"/create-user-before.sql", "/car_list_before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create_user_after.sql", "/car_list_after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void homePage_TestIfHomeWhenUrlPathEmpty() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk());
    }
    
    @Test
    void add_carPageTest() throws Exception {
        this.mockMvc.perform(get("/add_car")).andExpect(status().isOk());
    }

    @Test
    void addingCarTest() throws Exception {
        Car car = new Car("Toyota", "Camry", "2019", 190.0, 150.0, 7);
        this.mockMvc.perform(post("/add_car")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(toJson(car)))
                    .andExpect(status().isOk());

    }

    private String toJson(Car car) {
        return "{" +
                "\"carBrand\": \"" + car.getCarBrand() + "\"," +
                "\"carModel\": \"" + car.getCarModel() + "\"," +
                "\"year\": \"" + car.getYear() + "\"," +
                "\"power\": \"" + car.getPower() + "\"," +
                "\"price\": \"" + car.getPrice() + "\"," +
                "\"quantity\": \"" + car.getQuantity() + "\","
                + "}";
    }

}