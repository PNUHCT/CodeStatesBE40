package com.codestates.chapter2.di.psa;

public class NewBornBaby extends Child {
    @Override
    protected void smile() {
        System.out.println("신생아는 꺄르르 웃어요");
    }

    @Override
    protected void cry() {
        System.out.println("신생아는 자주 울어요");
    }

    @Override
    protected void sleep() {
        System.out.println("신생아는 거의 하루 종일 자요");
    }

    @Override
    protected void eat() {
        System.out.println("신생아는 분유만 먹어요");
    }
}