package org.serverless.workflow.lintercli.commands;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import org.serverless.workflow.api.WorkflowManager;
import org.serverless.workflow.api.validation.ValidationError;
import org.serverless.workflow.spi.WorkflowManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@ShellComponent
public class ValidateWorkflowCommand {

    @Autowired
    TemplateEngine templateEngine;

    @ShellMethod(value = "Validate Serverless Workflow", key = "validate")
    public String validateWorkflow(String filePath) {

        try {
            WorkflowManager workflowManager = WorkflowManagerProvider.getInstance().get();
            workflowManager.setMarkup(readFileContent(filePath));

            List<ValidationError> validationErrors = workflowManager.getWorkflowValidator().validate();

            if (validationErrors.size() < 1) {
                return templateEngine.process("validworkflow",
                                              new Context(Locale.US,
                                                          new HashMap<>()));
            } else {
                Map<String, Object> contextMap = new HashMap<>();
                contextMap.put("validationerrors",
                               validationErrors);

                Context templateContext = new Context(Locale.US,
                                                      contextMap);

                return templateEngine.process("validateworkflow",
                                              templateContext);
            }
        } catch (Exception e) {
            Map<String, Object> contextMap = new HashMap<>();
            contextMap.put("exception",
                           e.getMessage());

            Context templateContext = new Context(Locale.US,
                                                  contextMap);

            return templateEngine.process("validationexception",
                                          templateContext);
        }
    }

    private static String readFileContent(String filePath) throws IOException{
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath),
                                                 StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            throw new IOException(e);
        }
        return contentBuilder.toString();
    }
}
