package org.serverless.workflow.lintercli.prompts;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class WorkflowPromptProvider implements PromptProvider {

    @Value("${prompt.display}")
    private String serverName;

    @Override
    public AttributedString getPrompt() {

        return new AttributedString(serverName + " >",
                                    AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }
}
