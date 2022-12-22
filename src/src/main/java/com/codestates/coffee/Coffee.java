package com.codestates.coffee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@Getter
@Setter
@Table
public class Coffee {
    @Id
    private Long coffeeId;

    private String korName;

    private String engName;

    private Integer price;

    private String coffeeCode;

    private CoffeeStatus coffeeStatus = CoffeeStatus.COFFEE_FOR_SALE;

    public enum CoffeeStatus {
        COFFEE_FOR_SALE("판매중"),
        COFFEE_SOLD_OUT("판매 중지");

        @Getter
        private String status;

        CoffeeStatus(String status) {
            this.status = status;
        }
    }
}
