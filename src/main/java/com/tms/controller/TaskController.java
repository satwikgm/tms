package com.tms.controller;

import com.tms.dto.Task;
import com.tms.processor.CommandStepContext;
import com.tms.processor.CommandStepProcessorFactory;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import lombok.RequiredArgsConstructor;

@Controller("/task")
@RequiredArgsConstructor
public class TaskController {

    private final CommandStepProcessorFactory commandStepProcessorFactory;

    @Post("/save")
    public String createTask(@Body Task task) {

        CommandStepContext<Task> context = new CommandStepContext<>(task);
        commandStepProcessorFactory.createTaskProcessor().process(context);

        if (!context.isValid()) {
            return "Task creation failed: "+ context.getErrorMessage();
        }

        return "Task created successfully";
    }

    @Put("/updateStatus")
    public String updateTaskStatus(@Body Task task) {

        CommandStepContext<Task> context = new CommandStepContext<>(task);
        commandStepProcessorFactory.updateTaskProcessor().process(context);

        if (!context.isValid()) {
            return "Task update failed: "+ context.getErrorMessage();
        }

        return "Task update successfully";
    }
}
