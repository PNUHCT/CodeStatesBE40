package com.codestates.coffee;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CoffeePostDto {
    @NotBlank
    @Pattern(regexp = "^([a-zA-Z])(\\s?[a-zA-Z])*$", message = "영문(대소문자 모두 가능)만 허용합니다.")
    private String engName;

    @NotBlank
    @Pattern(regexp = "^[가-힣\\s]*$")
    private String korName;

    @Range(min = 100, max =50000)
    private int price;

    public String getEngName() { return engName; }

    public String getKorName() { return korName; }

    public int getPrice() {
        return price;
    }

}
