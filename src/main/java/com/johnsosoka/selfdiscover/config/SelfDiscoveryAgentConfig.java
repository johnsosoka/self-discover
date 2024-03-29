package com.johnsosoka.selfdiscover.config;

import com.johnsosoka.selfdiscover.agent.SelfDiscovery;
import com.johnsosoka.selfdiscover.agent.Solving;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SelfDiscoveryAgentConfig {

    /**
     * Provisions an AIService `SelfDiscoverAgent` which contains the prompts
     * which implement the SELF-DISCOVER algorithm to self-compose reasoning structures.
     * @param chatLanguageModel
     * @return
     */
    @Bean
    public SelfDiscovery selfDiscoveryAgent(ChatLanguageModel chatLanguageModel) {
        return AiServices.builder(SelfDiscovery.class)
                .chatLanguageModel(chatLanguageModel)
                .build();
    }

    /**
     * Provisions an AIService `SolverAgent` which contains the prompts for solving a given task.
     * The self-composed reasoning structures generated by the SelfDiscover Agent  are used to
     * solve the task.
     *
     * @param chatLanguageModel
     * @return
     */
    @Bean
    public Solving solverAgent(ChatLanguageModel chatLanguageModel) {
        return AiServices.builder(Solving.class)
                .chatLanguageModel(chatLanguageModel)
                .build();
    }
}
