package org.serverless.workflow.lintercli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class ApplicationConfig {
    public static final String TEMPLATES_BASE = "classpath:/templates/";

    @Bean
    public SpringResourceTemplateResolver textTemplateResolver() {
        SpringResourceTemplateResolver theResourceTemplateResolver =
                new SpringResourceTemplateResolver();
        theResourceTemplateResolver.setPrefix(TEMPLATES_BASE);
        theResourceTemplateResolver.setSuffix(".txt");
        theResourceTemplateResolver.setTemplateMode("text");
        theResourceTemplateResolver.setCharacterEncoding("UTF-8");
        theResourceTemplateResolver.setCacheable(false);
        theResourceTemplateResolver.setOrder(3);
        return theResourceTemplateResolver;
    }
}
