package com.tms.processor.steps;

import com.tms.dto.Task;
import com.tms.processor.CommandStep;
import com.tms.processor.CommandStepContext;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class ValidateProjectExistsStep implements CommandStep<Task> {


    @Override
    public void process(CommandStepContext<Task> context) {

        Task task = context.getData();
        if (task.getProjectId() == null || task.getProjectId().isBlank()) {
            context.setValid(false);
            context.setErrorMessage("Project Id is required");
            log.error("Validation failed: {}", context.getErrorMessage());
        }
    }
}
