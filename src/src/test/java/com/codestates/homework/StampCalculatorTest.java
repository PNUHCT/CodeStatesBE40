package com.codestates.homework;

import com.codestates.member.entity.Member;
import com.codestates.order.entity.Order;
import com.codestates.stamp.Stamp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codestates.helper.StampCalculator.calculateEarnedStampCount;
import static com.codestates.helper.StampCalculator.calculateStampCount;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StampCalculatorTest {
    Order order = new Order();
    int expected;
    int preStamp;
    int newStamp;

    // 초기화 조건
    @BeforeEach
    public void init () {
        newStamp = order.getOrderCoffees().stream().
                map(orderCoffee -> orderCoffee.getQuantity()).mapToInt(quantity -> quantity).sum();
        System.out.println("initialize Crypto Currency map");
    }

    @Test
    @DisplayName("실습1: 스탬프 카운트 계산 단위 테스트")
    public void calculateStampCountTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // Given(전제조건)
        expected = 5;
        preStamp = 5;
        // When(테스트 대상 지정)
        int actual = calculateStampCount(newStamp, preStamp);

        // Then(테스트 결과 검증)
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("실습1: 주문 후 누적 스탬프 카운트 계산 단위 테스트")
    public void calculateEarnedStampCountTest(){
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // Given(전제조건)
        expected = newStamp;

        // When(테스트 대상 지정)
        int actual = calculateEarnedStampCount(order);

        // Then(테스트 결과 검증)
        assertEquals(expected, actual);
    }
}
