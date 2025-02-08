package com.tms.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/test")
public class HelloC {

    @Get("/hello")
    public String hello() {
        return "hello";
    }
}
