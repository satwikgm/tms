package com.tms.processor;

import com.tms.dto.Task;
import com.tms.processor.steps.AssignTaskStep;
import com.tms.processor.steps.SaveTaskStep;
import com.tms.processor.steps.ValidateProjectExistsStep;
import com.tms.processor.steps.ValidateTaskStep;
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

    public CommandStepProcessor<Task> createTaskProcessor() {
        return new CommandStepProcessor<>(
                List.of(validateTaskStep,
                        validateProjectExistsStep,
                        assignTaskStep,
                        saveTaskStep));
    }
}
