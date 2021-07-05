package com.spring.learning.car_rental_20.controllerTest;

import com.spring.learning.car_rental_20.controller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePageTest() throws Exception {
        mockMvc.perform(get("").contentType("text/html")).andExpect(status().isOk());
    }
}
