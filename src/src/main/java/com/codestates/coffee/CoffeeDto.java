package com.codestates.coffee;

import com.codestates.validator.NotSpace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Optional;

public class CoffeeDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank
        private String korName;

        @NotBlank
        @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$",
                message = "커피명(영문)은 영문이어야 합니다(단어 사이 공백 한 칸 포함). 예) Cafe Latte")
        private String engName;

        @Range(min= 100, max= 50000)
        private int price;

        @NotBlank
        @Pattern(regexp = "^([A-Za-z]){3}$",
                message = "커피 코드는 3자리 영문이어야 합니다.")
        private String coffeeCode;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private long coffeeId;

        @NotSpace(message = "커피명(한글)은 공백이 아니어야 합니다.")
        private String korName;

        @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$", message = "커피명(영문)은 영문이어야 합니다. 예) Cafe Latte")
        private String engName;

        private Optional<@Range(min= 100, max= 50000) Integer> price = Optional.empty();

        private Coffee.CoffeeStatus coffeeStatus;

        public void setCoffeeId(long coffeeId) {
            this.coffeeId = coffeeId;
        }

        public int getPrice() {
            return price.orElse(0);
        }
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private long coffeeId;
        private String korName;
        private String engName;
        private int price;
        private Coffee.CoffeeStatus coffeeStatus;

        public String getCoffeeStatus() {
            return coffeeStatus.getStatus();
        }
    }
}
