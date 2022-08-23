package com.codestates.coffee.service;

import com.codestates.coffee.entity.Coffee;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CoffeeService {
    public Coffee createCoffee(Coffee coffee) {
        return coffee;
    }

    public Coffee updateCoffee(Coffee ceffee) {
        return ceffee;
    }

    public Coffee findCoffee(long coffeeId) {
        return new Coffee(coffeeId, "Americano", "아메리카노", 4100); //stub 데이터. 프로젝트 초반에 데이터 액세스 계층 없을 때 목업 데이터로 넘겨줄 수 있음
    }

    public List<Coffee> findCoffees() {
        // 원래는 데이터 베이스에서 가져오는 데이터
        return List.of( //List.of 메서드
            new Coffee(1, "Americano", "아메리카노", 4100),
            new Coffee(2, "CafeLatte", "카페라떼", 4800)
        );
    }

    public void deleteCoffee(long coffeeId) {
    }
}