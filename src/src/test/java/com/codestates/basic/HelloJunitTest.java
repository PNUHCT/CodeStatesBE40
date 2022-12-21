package com.codestates.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloJunitTest {

    @DisplayName("Hello Junit Test")
    @Test
    public void assertionTest1() {
        String actual = "Hello, JUnit";
        String expected = "Hello, JUnit";

        assertEquals(expected, actual);
    }
}
