package com.example.springasyncsample2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockingController {

    @GetMapping("block")
    public String blockingApi(String req) throws InterruptedException {
        Thread.sleep(2000);
        return req + "/blocking";
    }
}
