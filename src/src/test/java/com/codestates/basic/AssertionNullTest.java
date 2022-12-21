package com.codestates.basic;

import com.codestates.CryptoCurrency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class AssertionNullTest {

    @DisplayName("AssertionNull() Test")
    @Test
    public void assertionNullTest() {
        String currencyName = getCryptoCurrency("XRP");

        assertNull(currencyName, "should be null");
    }

    private String getCryptoCurrency(String unit) {
        return CryptoCurrency.map.get(unit);
    }
}
