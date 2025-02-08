package com.tms.processor.steps;

import com.tms.dto.Task;
import com.tms.processor.CommandStep;
import com.tms.processor.CommandStepContext;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class AssignTaskStep implements CommandStep<Task> {

    @Override
    public void process(CommandStepContext<Task> context) {
        Task task = context.getData();
        if(context.isValid()) {
            task.setAssignedTo("Unassigned");
            task.setStatus("New");
            log.info("Task assigned to default: Unassigned");
        }
    }
}
