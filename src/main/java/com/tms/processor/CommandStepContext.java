package com.tms.processor;

import lombok.Getter;
import lombok.Setter;

// The Context holds the object being processed(e.g. Task)
// and also holds the validation state
@Setter
@Getter
public class CommandStepContext<T> {

    private T data;
    private boolean isValid = true;
    private String errorMessage;

    public CommandStepContext(T data) {

        this.data = data;
    }
}
