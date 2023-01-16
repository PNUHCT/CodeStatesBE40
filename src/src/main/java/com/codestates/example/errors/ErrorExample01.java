package com.codestates.example.errors;

import com.codestates.example.operators.sample_data.Coffee;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class ErrorExample01 {
    public static void main(String[] args) {
        Mono.justOrEmpty(findVerifiedCoffee())
                .switchIfEmpty(Mono.error(new RuntimeException("Not found coffee")))
                .subscribe(
                        data-> log.info("{} : {}", data.getKorName(), data.getPrice()),
                        error-> log.error("# onError: {}", error.getMessage())
                );
    }
    private static Coffee findVerifiedCoffee() {
        // DB에서 Coffee 정보를 조회하는 로직 작성
        return null;
    }
}
