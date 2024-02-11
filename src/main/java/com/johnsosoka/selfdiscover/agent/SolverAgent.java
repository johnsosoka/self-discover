package com.johnsosoka.selfdiscover.agent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface SolverAgent {


    /**
     * Solve a given task using the self-composed reasoning structures.
     * @return
     */
    @UserMessage({
            "Using the provided reasoning structure, solve the given task.",

            "REASONING STRUCTURE:",
            "{{reasoningStructure}}",
            "---",
            "GIVEN TASK:",
            "{{task}}",
    })
    public String solveTask(@V("task")String task,
                            @V("reasoningStructure") String reasoningStructure);

}
