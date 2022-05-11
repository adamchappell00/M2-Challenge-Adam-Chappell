package com.adam.m2challengeadamchappell;


import com.adam.m2challengeadamchappell.controllers.ServiceController;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest(ServiceController.class)
public class ServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }


    @Test
    public void shouldDoTheThing(){
        assertEquals(1,2-1);
    }
}
