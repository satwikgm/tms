package com.tms.processor;

import com.tms.dto.Task;
import com.tms.processor.steps.*;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;

// This factory injects the required steps dynamically
// Creates a processor with all the steps related to task saving
@Singleton
@RequiredArgsConstructor
public class CommandStepProcessorFactory {

    private final ValidateTaskStep validateTaskStep;
    private final AssignTaskStep assignTaskStep;
    private final SaveTaskStep saveTaskStep;
    private final ValidateProjectExistsStep validateProjectExistsStep;
    private final UpdateTaskStatusStep updateTaskStatusStep;

    public CommandStepProcessor<Task> createTaskProcessor() {
        return new CommandStepProcessor<>(
                List.of(validateTaskStep,
                        validateProjectExistsStep,
                        assignTaskStep,
                        saveTaskStep));
    }

    public CommandStepProcessor<Task> updateTaskProcessor() {
        return new CommandStepProcessor<>(
                List.of(updateTaskStatusStep)
        );
    }
}
