package com.johnsosoka.selfdiscover.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReasoningServiceTests {


    @Autowired
    private ReasoningService reasoningService;

    @Test
    public void testReasoningService() {
        String task = "Lisa has 10 apples. She gives 3 apples to her friend and then buys 5 more apples from the store. How many apples does Lisa have now?";

        String reasoningStructure = reasoningService.composeReasoningStructure(task);

        String answer = reasoningService.solveTask(task, reasoningStructure);
        System.out.println("Answer: " + answer);

        // The range of problems that can be solved are not limited to arithmetic problems.
        Assertions.assertEquals("12", answer);
    }
}
