package com.example.springasyncsample2.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsyncService {

    @Async
    public ListenableFuture<String> async() throws InterruptedException {
        log.info("async call");

        // wait 2s
        TimeUnit.SECONDS.sleep(2);

        return new AsyncResult<>("async call");
    }
}
