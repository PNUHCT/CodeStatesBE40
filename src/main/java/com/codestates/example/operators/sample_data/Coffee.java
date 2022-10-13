package com.codestates.example.operators.sample_data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Coffee {
    private String korName;
    private String engName;
    private int price;
    private String code;
}
