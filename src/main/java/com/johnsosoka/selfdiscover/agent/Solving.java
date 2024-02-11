package com.johnsosoka.selfdiscover.agent;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface Solving {


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


    /**
     * Extract the answer from the reasoned solution.
     * @param answer
     * @return
     */
    @UserMessage({
            "Extract the answer from the reasoned solution.",
            "Only include the answer in your extraction, do not include any other information.",

            "REASONED SOLUTION:",
            "{{answer}}",
    })
    public String extractAnswer(@V("answer") String answer);

}
