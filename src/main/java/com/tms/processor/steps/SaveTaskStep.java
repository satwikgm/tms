package com.tms.processor.steps;

import com.tms.dto.Task;
import com.tms.processor.CommandStep;
import com.tms.processor.CommandStepContext;
import com.tms.repository.TaskRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Singleton
@Slf4j
@RequiredArgsConstructor
public class SaveTaskStep implements CommandStep<Task> {

    private final TaskRepository taskRepository;

    @Override
    public void process(CommandStepContext<Task> context) {
        Task task = context.getData();
        if (context.isValid()) {
            task.setId("TSC-"+new Random().nextInt(1000));
            taskRepository.saveTask(task).subscribe(t -> {
                log.info("Task saved successfully: {}", t);
            });
        } else {
            log.error("Skipping task, task is invalid");
        }
    }
}
