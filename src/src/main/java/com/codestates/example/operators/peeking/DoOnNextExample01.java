package com.codestates.example.operators.peeking;

import com.codestates.example.operators.sample_data.Coffee;
import com.codestates.example.operators.sample_data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class DoOnNextExample01 {
    public static void main(String[] args) {
        Flux
                .fromIterable(SampleData.coffeeList)
                .doOnNext(coffee -> validateCoffee(coffee))
                .subscribe(data -> log.info("{} : {}", data.getKorName(), data.getPrice()));
    }

    // 유효성 검증용 void 메서드
    private static void validateCoffee(Coffee coffee) {
        if(coffee == null) {
            throw new RuntimeException("Not found coffee");
        }
    }
}
