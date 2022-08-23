package com.codestates.coffee;

import com.codestates.coffee.entity.Coffee;
import com.codestates.coffee.CoffeePatchDto;
import com.codestates.coffee.CoffeePostDto;
import org.springframework.stereotype.Component;

@Component  // (1)
public class CoffeeMapper {
    // (2) MemberPostDto를 Member로 변환
    public Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto) {
        return new Coffee(0L,
                coffeePostDto.getEngName(),
                coffeePostDto.getKorName(),
                coffeePostDto.getPrice());
    }

    // (3) MemberPatchDto를 Member로 변환
    public Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto) {
        return new Coffee(coffeePatchDto.getCoffeeId(),
                null,
                coffeePatchDto.getEngName(),
                coffeePatchDto.getPrice());
    }

    // (4) Member를 MemberResponseDto로 변환
    public CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee) {
        return new CoffeeResponseDto(coffee.getCoffeeId(),
                coffee.getEngName(),
                coffee.getKorName(),
                coffee.getPrice());
    }
}