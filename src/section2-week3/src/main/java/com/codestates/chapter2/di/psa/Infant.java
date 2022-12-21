package com.codestates.chapter2.di.psa;

public class Infant extends Child {
    @Override
    protected void smile() {
        System.out.println("영아는 해맑게 웃어요");
    }

    @Override
    protected void cry() {
        System.out.println("영아는 서럽게 울어요");
    }

    @Override
    protected void sleep() {
        System.out.println("영아부터는 밤에 잠을 자기 시작해요");
    }

    @Override
    protected void eat() {
        System.out.println("영아부터는 이유식을 시작해요");
    }
}