package com.adam.m2challengeadamchappell;


import com.adam.m2challengeadamchappell.controllers.ServiceController;


import com.adam.m2challengeadamchappell.models.MathSolution;
import com.adam.m2challengeadamchappell.models.Month;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(ServiceController.class)
public class ServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void contextLoads() {
    }

    @Test
    public void returnsMonthObjectWhenGivenValidMonthNumber() throws Exception {
        // Arrange - Create two Months as Expected JSON Outputs
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
        // Act - Perform an Out-of-Bounds Request
        mockMvc.perform(get("/month/13"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());      // Assert Unprocessable HttpStatus

        // Act - Perform an Out-of-Bounds Request - AGAIN
        mockMvc.perform(get("/month/0"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());      // Assert Unprocessable HttpStatus
    }

    @Test
    public void returnsRandomMonthObjectForRandomMonth() throws Exception {
        // Act
        mockMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk())                                 // Assert (status code is 201)
                .andExpect(jsonPath("$.number").isNotEmpty())     // Assert there is a non-empty number field
                .andExpect(jsonPath("$.name").isNotEmpty());      // Assert there is a non-empty month name field

    }

    @Test
    public void shouldReturnAdditionSolutionWithGoodOperands() throws Exception {
        // Arrange - Two solutions for Input and Two Expected Outputs for Comparison
        MathSolution solution1 = new MathSolution(2,3);
        String inputSolution1 = mapper.writeValueAsString(solution1);
        MathSolution solution2 = new MathSolution(5,7);
        String inputSolution2 = mapper.writeValueAsString(solution2);

        MathSolution outputSolution1 = new MathSolution(2,3,"add", 5);
        String expectedOutput1 = mapper.writeValueAsString(outputSolution1);
        MathSolution outputSolution2 = new MathSolution(5,7,"add", 12);
        String expectedOutput2 = mapper.writeValueAsString(outputSolution2);

        // Act - Perform Request 1
        mockMvc.perform(post("/add")
                        .content(inputSolution1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                     // Assert HttpStatus 200 Response
                .andExpect(content().json(expectedOutput1));    // Assert the response body matches expectation

        // Act - Perform Request 2
        mockMvc.perform(post("/add")
                        .content(inputSolution2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                     // Assert HttpStatus 200 Response
                .andExpect(content().json(expectedOutput2));    // Assert the response body matches expectation
    }

    @Test
    public void shouldReturnSubtractionSolutionWithGoodOperands() throws Exception {
        // Arrange - Two solutions for Input and Two Expected Outputs for Comparison
        MathSolution solution1 = new MathSolution(5,2);
        String inputSolution1 = mapper.writeValueAsString(solution1);
        MathSolution solution2 = new MathSolution(12,7);
        String inputSolution2 = mapper.writeValueAsString(solution2);

        MathSolution outputSolution1 = new MathSolution(5,2,"subtract", 3);
        String expectedOutput1 = mapper.writeValueAsString(outputSolution1);
        MathSolution outputSolution2 = new MathSolution(12,7,"subtract", 5);
        String expectedOutput2 = mapper.writeValueAsString(outputSolution2);

        // Act - Perform Request 1
        mockMvc.perform(post("/subtract")
                        .content(inputSolution1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                     // Assert HttpStatus 200 Response
                .andExpect(content().json(expectedOutput1));    // Assert the response body matches expectation

        // Act - Perform Request 2
        mockMvc.perform(post("/subtract")
                        .content(inputSolution2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                     // Assert HttpStatus 200 Response
                .andExpect(content().json(expectedOutput2));    // Assert the response body matches expectation
    }

    @Test
    public void shouldReturnMultiplicationSolutionWithGoodOperands() throws Exception {
        // Arrange - Two solutions for Input and Two Expected Outputs for Comparison
        MathSolution solution1 = new MathSolution(3,2);
        String inputSolution1 = mapper.writeValueAsString(solution1);
        MathSolution solution2 = new MathSolution(12,5);
        String inputSolution2 = mapper.writeValueAsString(solution2);

        MathSolution outputSolution1 = new MathSolution(3,2,"multiply", 6);
        String expectedOutput1 = mapper.writeValueAsString(outputSolution1);
        MathSolution outputSolution2 = new MathSolution(12,5,"multiply", 60);
        String expectedOutput2 = mapper.writeValueAsString(outputSolution2);

        // Act - Perform Request 1
        mockMvc.perform(post("/multiply")
                        .content(inputSolution1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                     // Assert HttpStatus 200 Response
                .andExpect(content().json(expectedOutput1));    // Assert the response body matches expectation

        // Act - Perform Request 2
        mockMvc.perform(post("/multiply")
                        .content(inputSolution2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                     // Assert HttpStatus 200 Response
                .andExpect(content().json(expectedOutput2));    // Assert the response body matches expectation
    }

    @Test
    public void shouldReturnDivisionSolutionWithGoodOperands() throws Exception {
        // Arrange - Three solutions for Input and Two Expected Outputs for Comparison
        MathSolution solution1 = new MathSolution(4,2);
        String inputSolution1 = mapper.writeValueAsString(solution1);
        MathSolution solution2 = new MathSolution(18,3);
        String inputSolution2 = mapper.writeValueAsString(solution2);
        // Third input and solution will expect a decimal point remainder to be trimmed from the Integer
        MathSolution solution3 = new MathSolution(12,5);
        String inputSolution3 = mapper.writeValueAsString(solution3);

        MathSolution outputSolution1 = new MathSolution(4,2,"divide", 2);
        String expectedOutput1 = mapper.writeValueAsString(outputSolution1);
        MathSolution outputSolution2 = new MathSolution(18,3,"divide", 3);
        String expectedOutput2 = mapper.writeValueAsString(outputSolution2);
        MathSolution outputSolution3 = new MathSolution(12,5,"divide", 2);
        String expectedOutput3 = mapper.writeValueAsString(outputSolution3);

        // Act - Perform Request 1
        mockMvc.perform(post("/divide")
                        .content(inputSolution1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                     // Assert HttpStatus 200 Response
                .andExpect(content().json(expectedOutput1));    // Assert the response body matches expectation

        // Act - Perform Request 2
        mockMvc.perform(post("/divide")
                        .content(inputSolution2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                     // Assert HttpStatus 200 Response
                .andExpect(content().json(expectedOutput2));    // Assert the response body matches expectation

        // Act - Perform Request 3
        mockMvc.perform(post("/divide")
                        .content(inputSolution3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())                     // Assert HttpStatus 200 Response
                .andExpect(content().json(expectedOutput3));    // Assert the response body matches expectation
    }
}
