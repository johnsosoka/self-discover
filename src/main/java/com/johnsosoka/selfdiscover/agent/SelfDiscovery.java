package com.johnsosoka.selfdiscover.agent;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

import java.util.List;

/**
 * The reasoning agent implements several prompts which together form the SELF-DISCOVER algorithm
 *
 * "SELF-DISCOVER: Large Language Models Self-Compose Reasoning Structures"
 * https://arxiv.org/pdf/2402.03620.pdf
 */
public interface SelfDiscovery {

    /**
     * Selects reasoning modules that will help solve a task.
     * @param task
     * @param allReasoningModules
     * @return
     */
    @UserMessage({
            "Select several reasoning modules that are crucial to utilize in order to solve the given task.",
            "Do not explain your reasoning, simply list the reasoning modules that you select.",

            "GIVEN TASK:",
            "{{task}}",
            "---",
            "AVAILABLE REASONING MODULES:",
            "{{allReasoningModules}}",
    })
    public String selectModules(@V("task") String task,
                                      @V("allReasoningModules") List<String> allReasoningModules);

    /**
     * Adapts each reasoning module to better help solve the task.
     * @return
     */
    @UserMessage({
            "Rephrase and specify each reasoning module so that it better helps solving the task:",
            "Do not explain your reasoning or solve the task, simply adapt each selected reasoning module to better help solve the task.",

            "GIVEN TASK:",
            "{{task}}",
            "---",
            "SELECTED REASONING MODULES:",
            "{{selectedReasoningModules}}",
    })
    public String adaptModules(@V("task") String task,
                                     @V("selectedReasoningModules") String selectedReasoningModules);

    /**
     * Implement a reasoning structure for solvers to follow step-by-step to arrive at a correct solution.
     * @return
     */
    @UserMessage({
            "Transform the reasoning modules into a step-by-step reasoning plan in JSON format.",
            "Do not explain your reasoning or solve the task, simply create an actionable reasoning plan",
            "for solvers solve using these adapted reasoning modules..",

            "GIVEN TASK:",
            "{{task}}",
            "---",
            "ADAPTED REASONING MODULES:",
            "{{adaptedReasoningModules}}",
    })
    public String implement(@V("task") String task,
                            @V("adaptedReasoningModules") String adaptedReasoningModules);
}
