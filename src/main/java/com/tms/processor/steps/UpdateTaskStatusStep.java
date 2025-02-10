package com.tms.processor.steps;

import com.tms.dto.Task;
import com.tms.processor.CommandStep;
import com.tms.processor.CommandStepContext;
import com.tms.repository.TaskRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Singleton
public class UpdateTaskStatusStep implements CommandStep<Task> {

    private final TaskRepository taskRepository;

    @Override
    public void process(CommandStepContext<Task> context) {

        Task task = context.getData();
        if (task.getId() == null || task.getProjectId() == null || task.getId().isBlank() || task.getProjectId().isBlank()
        || task.getStatus() == null || task.getStatus().isBlank()) {
            context.setValid(false);
            context.setErrorMessage("Either of Task Id or Project Id is missing");
            log.info("Task status could not be updated: {}", context.getErrorMessage());
        } else {
            taskRepository.updateTaskStatus(task)
                    .subscribe(t -> log.info("Task status updated successfully"));
        }
    }
}
