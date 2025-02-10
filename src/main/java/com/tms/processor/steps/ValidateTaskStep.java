package com.tms.processor.steps;

import com.tms.dto.Task;
import com.tms.processor.CommandStep;
import com.tms.processor.CommandStepContext;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

// Individual Step (1st in the Order)
// Each of these steps modifies Task or stops processing if something is invalid
@Singleton
@Slf4j
public class ValidateTaskStep implements CommandStep<Task> {

    @Override
    public void process(CommandStepContext<Task> context) {
        Task task = context.getData();
        if (task.getName() == null || task.getName().isBlank()) {
            context.setValid(false);
            context.setErrorMessage("Task name is required");
            log.error("Validation failed: {}", context.getErrorMessage());
        }
        if (task.getProjectId() == null || task.getProjectId().isBlank()) {
            context.setValid(false);
            context.setErrorMessage("Project Id is required");
            log.error("Validation failed: {}", context.getErrorMessage());
        }
    }
}
