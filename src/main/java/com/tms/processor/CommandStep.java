package com.tms.processor;

public interface CommandStep<Context> {

    void process(CommandStepContext<Context> context);
}
