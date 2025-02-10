package com.tms.processor;

// Generic Command Step Context
// Each processing step implements this interface
public interface CommandStep<Context> {

    void process(CommandStepContext<Context> context);
}
