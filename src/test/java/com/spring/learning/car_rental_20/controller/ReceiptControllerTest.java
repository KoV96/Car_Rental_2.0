package com.spring.learning.car_rental_20.controller;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("okurylyk@luxoft.com")
@TestPropertySource(value = "/application-test.properties")
@Sql(value = {"/create-user-before.sql", "/car_list_before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create_user_after.sql", "/car_list_after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ReceiptControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ReceiptController receiptController;

    @Test
    public void carListPageTest() throws Exception {
        this.mockMvc.perform(get("/car_list"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void carListTest() throws Exception {
        this.mockMvc.perform(get("/car_list"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//tbody[@id='car_list']/tr").nodeCount(3));
    }

    /*
    @Test
    public void showUserReceiptTest() throws Exception {
        this.mockMvc.perform(get("/receipt"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk());
    } */

}