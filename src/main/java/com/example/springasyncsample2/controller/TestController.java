package com.example.springasyncsample2.controller;

import com.example.springasyncsample2.service.AsyncService;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TestController {
    private final AsyncService asyncService;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping("some-block-api")
    public String someBlockAPI() throws InterruptedException {
        Thread.sleep(2000);
        log.info("someBlockAPI call");
        return String.format("some-block-api call, timestamp : %s", LocalDateTime.now().format(dtf));
    }

    @GetMapping("some-async-api")
    public String someAsyncAPI() throws InterruptedException {
        // AsyncConfig에서 @EnableAsync가 없으면 @Async어노테이션은 작동하지 않는다.

        //CompletableFuture<String> cf = asyncService.async1().completable();
        asyncService.async().addCallback(System.out::println, ex -> System.out.println(ex.getMessage()));
        return String.format("some-block-api call, timestamp : %s", LocalDateTime.now().format(dtf));
    }

    @GetMapping("some-async-api2")
    public ListenableFuture<String> someAsyncAPI2() throws InterruptedException {
        return asyncService.async();
    }
}
