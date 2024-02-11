package com.johnsosoka.selfdiscover.service;

import com.johnsosoka.selfdiscover.agent.SelfDiscovery;
import com.johnsosoka.selfdiscover.agent.Solving;
import com.johnsosoka.selfdiscover.config.ReasoningModuleConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReasoningService {

    private final ReasoningModuleConfig reasoningModuleConfig;
    private final SelfDiscovery selfDiscovery;
    private final Solving solving;

    /**
     * Orchestrates the SelfDiscover AIService, which contains prompts that implement the SELF-DISCOVER algorithm.
     * The `SelfDiscover` AIService composes task-specific reasoning structures for solvers to follow step-by-step to arrive at a solution.
     * @param task
     * @return Reasoning structure composed by the SelfDiscover AIService
     */
    public String composeReasoningStructure(String task) {
        log.info("Composing reasoning structure for task: {}", task);
        String selectedReasoningModules = selfDiscovery.selectModules(task, reasoningModuleConfig.getReasoningModules());
        log.info("Selected reasoning modules: {}", selectedReasoningModules);
        String adaptedReasoningModules = selfDiscovery.adaptModules(task, selectedReasoningModules);
        log.info("Adapted reasoning modules: {}", adaptedReasoningModules);

        // Operationalize the reasoning modules into a step-by-step reasoning plan
        String reasoningPlan = selfDiscovery.implement(task, adaptedReasoningModules);
        log.info("Reasoning plan: {}", reasoningPlan);

        return reasoningPlan;
    }

    /**
     * Using the self-composed reasoning structure, solve the given task.
     * @param task
     * @param composedReasoningStructure
     * @return
     */
    public String solveTask(String task, String composedReasoningStructure) {
        // This response contains the answer and likely some other information
        String reasonedAnswer = solving.solveTask(task, composedReasoningStructure);
        // Extract the answer from the reasoned solution
        return solving.extractAnswer(reasonedAnswer);
    }
}
