package com.example.springboot.appointment_management;

import com.example.springboot.appointment_management.controller.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class HomeControllerTests {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        HomeController homeController = new HomeController();
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    void loginPage_Test() throws Exception {
        mockMvc.perform(get("/loginPage"))
                .andExpect(status().isOk())
                .andExpect(view().name("login-page"));
    }

    @Test
    void errorPage_Test() throws Exception {
        mockMvc.perform(get("/error"))
                .andExpect(status().isOk())
                .andExpect(view().name("error-page"));
    }

    @Test
    void homePage_Test() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("home-page"));
    }

    @Test
    void accessDeniedPage_Test() throws Exception {
        Exception exception = assertThrows(NestedServletException.class, () -> {
            mockMvc.perform(get("/access-denied"))
                    .andExpect(status().isNotFound());
        });
        String expectedMessage = "Request processing failed; nested exception is com.example.springboot.appointment_management.exception.MyException: Access Denied";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
