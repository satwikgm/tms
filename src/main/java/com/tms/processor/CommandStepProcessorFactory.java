package com.tms.processor;

import com.tms.dto.Task;
import com.tms.processor.steps.AssignTaskStep;
import com.tms.processor.steps.SaveTaskStep;
import com.tms.processor.steps.ValidateTaskStep;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class CommandStepProcessorFactory {

    private final ValidateTaskStep validateTaskStep;
    private final AssignTaskStep assignTaskStep;
    private final SaveTaskStep saveTaskStep;

    public CommandStepProcessor<Task> createTaskProcessor() {
        return new CommandStepProcessor<>(
                List.of(validateTaskStep, assignTaskStep, saveTaskStep)
        );
    }
}
