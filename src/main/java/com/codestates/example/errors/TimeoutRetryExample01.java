package com.codestates.example.errors;

import com.codestates.example.operators.sample_data.Coffee;
import com.codestates.example.operators.sample_data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Collectors;

@Slf4j
public class TimeoutRetryExample01 {
    public static void main(String[] args) throws InterruptedException {
        getCoffees()
                .collect(Collectors.toSet())
                .subscribe(bookSet -> bookSet.stream()
                        .forEach(data -> log.info("{} : {}", data.getKorName(), data.getPrice())));
        Thread.sleep(12000);
    }

    private static Flux<Coffee> getCoffees () {
        final int [] count = {0};
        return Flux
                .fromIterable(SampleData.coffeeList)
                .delayElements(Duration.ofMillis(500))
                .map(coffee -> {
                    try {
                        count[0]++;
                        if(count[0] ==3 ) {
                            Thread.sleep(2000);
                        }
                    }
                    catch (InterruptedException e) {
                    }
                    return coffee;
                })
                .timeout(Duration.ofSeconds(2))
                .retry(1)
                .doOnNext(coffee -> log.info("# getCoffees > doOnNext: {}, {}", coffee.getKorName(), coffee.getPrice()));
    }
}
