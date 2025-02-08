package com.tms.processor.steps;

import com.tms.dto.Task;
import com.tms.processor.CommandStep;
import com.tms.processor.CommandStepContext;
import com.tms.repository.TaskRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
@RequiredArgsConstructor
public class SaveTaskStep implements CommandStep<Task> {

    private final TaskRepository taskRepository;

    @Override
    public void process(CommandStepContext<Task> context) {
        if (context.isValid()) {
            taskRepository.saveTask(context.getData()).subscribe(task -> {
                log.info("Task saved successfully: {}", task);
            });
        } else {
            log.error("Skipping task, task is invalid");
        }
    }
}
