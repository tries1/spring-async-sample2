package com.example.springasyncsample2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class BlockingController {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping("some-api1")
    public String someAPI1() throws InterruptedException {
        String now = LocalDateTime.now().format(dtf);
        Thread.sleep(2000);
        return String.format("some-api1 call, timestamp : %s", now);
    }
}
