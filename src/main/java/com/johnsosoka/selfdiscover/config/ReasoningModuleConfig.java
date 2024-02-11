package com.johnsosoka.selfdiscover.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * All reasoning modules are stored in yml.
 */
@Configuration
@ConfigurationProperties(prefix = "reasoning")
public class ReasoningModuleConfig {

    private List<String> modules;

    public List<String> getReasoningModules() {
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }

}
