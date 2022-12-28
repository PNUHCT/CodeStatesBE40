package com.codestates.example.operators.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.*;

@Slf4j
public class CreateExample {
    private static List<Integer> source = Arrays.asList(1,2,3,4,5,8,7,18,69);

    public static void main(String[] args) throws InterruptedException {
        Flux
                .create((FluxSink<Integer> sink)-> {
                    sink.onRequest(n -> {
                        for (int i = 0; i < source.size(); i++) {
                            sink.next(source.get(i));
                        }
                        sink.complete();
                    });
                    sink.onDispose(() -> log.info("# clean up"));
                }).subscribe(data->log.info("# onNext: {}",data));
    }
}
