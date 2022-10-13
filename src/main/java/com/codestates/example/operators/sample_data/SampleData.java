package com.codestates.example.operators.sample_data;


import java.util.*;

public class SampleData {
    public static List<Coffee> coffeeList = List.of(
            new Coffee("아메리카노", "Americano", 2500, "AMR"),
            new Coffee("카페라떼", "CafeLatte", 3500, "CFR"),
            new Coffee("바닐라 라떼", "Vanilla Latte", 4500, "VNL"),
            new Coffee("카라멜 마끼아또", "Caramel Macchiato", 5500, "CRM"),
            new Coffee("에스프레소", "Espresso", 5000, "ESP")
    );

    // A 지점 카페의 월별 매출
    public static final List<Integer> salesOfCafeA = Arrays.asList(
            5_500_000, 4_200_000, 3_500_000, 5_000_000, 3_700_000, 4_000_000, 5_300_000, 5_800_000,
            3_500_000, 2_900_000, 5_400_000, 4_900_000
    );

    // B 지점 카페의 월별 매출
    public static final List<Integer> salesOfCafeB = Arrays.asList(
            2_500_000, 3_100_000, 4_300_000, 3_500_000, 3_200_000, 2_800_000, 3_100_000, 4_200_000,
            3_100_000, 3_200_000, 3_400_000, 4_100_000
    );

    // C 지점 카페의 월별 매출
    public static final List<Integer> salesOfCafeC = Arrays.asList(
            5_500_000, 5_100_000, 5_300_000, 5_500_000, 4_700_000, 4_800_000, 4_100_000, 5_200_000,
            5_100_000, 4_200_000, 4_400_000, 5_100_000
    );
}
