package com.codestates.example.operators.peeking;

import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class LogExample01 {
    public static void main(String[] args) {
        Flux
                .fromStream(Stream.of(2,3,4,5,6))
                .log()
                .reduce((a,b)-> a+b)
                .log()
                .subscribe(System.out::println);
    }
}
