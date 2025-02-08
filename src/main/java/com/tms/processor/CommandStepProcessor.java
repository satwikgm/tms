package com.tms.processor;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import javax.naming.Context;
import java.util.List;

@Singleton
@RequiredArgsConstructor
public class CommandStepProcessor<Context> {

    private final List<CommandStep<Context>> commandSteps;

    public void process(CommandStepContext<Context> context) {
        for (CommandStep<Context> step : commandSteps) {
            step.process(context);
            if(!context.isValid()) {
                break;
            }
        }
    }
}
