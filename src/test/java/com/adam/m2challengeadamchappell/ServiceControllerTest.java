package com.adam.m2challengeadamchappell;


import com.adam.m2challengeadamchappell.controllers.ServiceController;


import com.adam.m2challengeadamchappell.models.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(ServiceController.class)
public class ServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void contextLoads() {
    }

    @Test
    public void returnsMonthObjectWhenGivenValidMonthNumber() throws Exception {
        // Arrange Two Month Objects as Expected JSON Outputs
        Month month = new Month(7,"July");
        String expectedOutputJson = mapper.writeValueAsString(month);

        Month month2 = new Month(11, "November");
        String expectedOutputJson2 = mapper.writeValueAsString(month2);

        // Act - Perform the Get Request with the Month Number
        mockMvc.perform(get("/month/7"))
                .andDo(print())
                .andExpect(status().isOk())                         // Assert (status code is 201)
                .andExpect(content().json(expectedOutputJson));     // Assert the response object is the expected month output

        // Act - Perform a second Get request to verify second output, and that the first input wasn't a fluke or default
        mockMvc.perform(get("/month/11"))
                .andDo(print())
                .andExpect(status().isOk())                         // Assert Ok HttpStatus
                .andExpect(content().json(expectedOutputJson2));    // Assert the response object is the expected month output

    }

    @Test
    public void respondsWithUnprocessableEntityWhenMonthIsOutOfBounds() throws Exception {
        // Act - Perform an Out of Bounds Request
        mockMvc.perform(get("/month/13"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());      // Assert Unprocessable HttpStatus

        // Act - Perform an Out of Bounds Request - AGAIN
        mockMvc.perform(get("/month/0"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());      // Assert Unprocessable HttpStatus
    }

    @Test
    public void returnsRandomMonthObjectForRandomMonth() throws Exception {
        // Act
        mockMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk())                                 // ASSERT (status code is 201)
                .andExpect(jsonPath("$.number").isNotEmpty())     // ASSERT there is a non-empty number field
                .andExpect(jsonPath("$.name").isNotEmpty());      // ASSERT there is a non-empty month name field

    }
}
