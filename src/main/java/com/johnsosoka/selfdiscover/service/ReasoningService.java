package com.johnsosoka.selfdiscover.service;

import com.johnsosoka.selfdiscover.agent.SelfDiscoverAgent;
import com.johnsosoka.selfdiscover.agent.SolverAgent;
import com.johnsosoka.selfdiscover.config.ReasoningModuleConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReasoningService {

    private final ReasoningModuleConfig reasoningModuleConfig;
    private final SelfDiscoverAgent selfDiscoverAgent;
    private final SolverAgent solverAgent;

    /**
     * Orchestrates the SelfDiscover AIService, which contains prompts that implement the SELF-DISCOVER algorithm.
     * The `SelfDiscover` AIService composes reasoning structures for solvers to follow step-by-step to arrive at a solution.
     * @param task
     * @return
     */
    public String composeReasoningStructure(String task) {
        log.info("Composing reasoning structure for task: {}", task);
        List<String> selectedReasoningModules = selfDiscoverAgent.selectModules(task, reasoningModuleConfig.getReasoningModules());
        log.info("Selected reasoning modules: {}", selectedReasoningModules);
        List<String> adaptedReasoningModules = selfDiscoverAgent.adaptModules(task, selectedReasoningModules);
        log.info("Adapted reasoning modules: {}", adaptedReasoningModules);

        // Operationalize the reasoning modules into a step-by-step reasoning plan
        String reasoningPlan = selfDiscoverAgent.implement(task, adaptedReasoningModules);
        log.info("Reasoning plan: {}", reasoningPlan);

        String answer = solverAgent.solveTask(task, reasoningPlan);
        log.info("Answer: {}", answer);
        return answer;
    }
}
