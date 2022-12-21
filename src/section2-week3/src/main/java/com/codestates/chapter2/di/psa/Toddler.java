package com.codestates.chapter2.di.psa;

public class Toddler extends Child {
    @Override
    protected void smile() {
        System.out.println("유아는 웃길 때 방긋 웃어요");
    }

    @Override
    protected void cry() {
        System.out.println("유아는 화가나면 짖어요");
    }

    @Override
    protected void sleep() {
        System.out.println("유아는 낮잠을 건너뛰고 밤잠만 자요");
    }

    @Override
    protected void eat() {
        System.out.println("유아는 딱딱한 걸 먹기 시작해요");
    }
}