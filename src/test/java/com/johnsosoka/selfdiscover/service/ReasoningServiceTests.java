package com.johnsosoka.selfdiscover.service;


import com.johnsosoka.selfdiscover.agent.SelfDiscoverAgent;
import com.johnsosoka.selfdiscover.agent.SolverAgent;
import com.johnsosoka.selfdiscover.config.ReasoningModuleConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
public class ReasoningServiceTests {


    @Autowired
    private SelfDiscoverAgent selfDiscoverAgent;

    @Autowired
    SolverAgent solverAgent;

    @Autowired
    private ReasoningModuleConfig reasoningModuleConfig;



    @Test
    public void testReasoningService() {
        String task = "Lisa has 10 apples. She gives 3 apples to her friend and then buys 5 more apples from the store. How many apples does Lisa have now?";

        List<String> selectedModules = selfDiscoverAgent.selectModules(task, reasoningModuleConfig.getReasoningModules());
        List<String> adaptedModules = selfDiscoverAgent.adaptModules(task, selectedModules);
        String reasoningPlan = selfDiscoverAgent.implement(task, adaptedModules);
        String answer = solverAgent.solveTask(task, reasoningPlan);
    }
}
