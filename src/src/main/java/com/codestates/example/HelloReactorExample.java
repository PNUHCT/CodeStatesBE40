package com.codestates.example;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class HelloReactorExample {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .just("Hello", "Reactor")
                .map(message -> message.toUpperCase())
                .publishOn(Schedulers.parallel())
                .subscribe(System.out::println,
                        error -> System.out.println(error.getMessage()),
                        ()-> System.out.println("# onComplete"));

        Thread.sleep(100L);
    }
}