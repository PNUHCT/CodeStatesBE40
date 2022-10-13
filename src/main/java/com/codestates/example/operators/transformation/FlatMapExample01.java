package com.codestates.example.operators.transformation;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class FlatMapExample01 {
    public static void main(String[] args) throws InterruptedException{
        Flux
                .range(2, 8)
                .flatMap(dan -> Flux
                        .range(1,9)
                        .publishOn(Schedulers.parallel())
                        .map(num -> dan + " x " + num + " = " + dan * num))
                .subscribe(log::info);
        Thread.sleep(100L);
    }
}
