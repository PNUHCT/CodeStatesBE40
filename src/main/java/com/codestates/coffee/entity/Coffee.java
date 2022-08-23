package com.codestates.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    private long coffeeId;
    private String engName;
    private String korName;
    private int price;
}
