package com.tms.processor;

import lombok.Getter;
import lombok.Setter;

public class CommandStepContext<T> {

    @Getter
    @Setter
    private T data;
    @Setter
    @Getter
    private boolean isValid = true;
    @Setter
    @Getter
    private String errorMessage;

    public CommandStepContext(T data) {

        this.data = data;
    }
}
