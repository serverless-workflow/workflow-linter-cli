package org.serverless.workflow.lintercli;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;

public class InitThymeleafBean implements InitializingBean {

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    SpringResourceTemplateResolver textTemplateResolver;

    @Override
    public void afterPropertiesSet() throws Exception {
        templateEngine.setTemplateResolver(textTemplateResolver);
    }
}
