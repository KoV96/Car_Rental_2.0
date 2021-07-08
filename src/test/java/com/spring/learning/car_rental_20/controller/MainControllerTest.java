package com.spring.learning.car_rental_20.controller;

import com.spring.learning.car_rental_20.model.User;
import com.spring.learning.car_rental_20.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(value = "/application-test.properties")
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    UserService userService;
    private final User user = new User("Alex", "Al", "1", "Alex@v.com");


    @Test
    void homePage_TestIfHomeWhenUrlPathEmpty() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    void registrationPage() throws Exception {
        this.mockMvc.perform(get("/register")).andExpect(status().isOk());
    }

    @Test
    void processRegistration() {
    }

    @Test
    public void accessTest() throws Exception {
        this.mockMvc.perform(get("/user_page"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void correctLoginTest() throws Exception{
        this.mockMvc.perform(formLogin().user(user.getEmail())
                .password(user.getPassword()))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user_page"));
    }
}