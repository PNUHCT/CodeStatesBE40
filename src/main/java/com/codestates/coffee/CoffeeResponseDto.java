package com.codestates.coffee;

import lombok.*;

//@Builder
@Getter
//@Setter
//@NoArgsConstructor // ALlArgsConstructor랑 같이 쓰면 안됨
@AllArgsConstructor
public class CoffeeResponseDto {
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;
}