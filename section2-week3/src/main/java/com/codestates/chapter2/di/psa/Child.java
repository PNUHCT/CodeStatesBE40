package com.codestates.chapter2.di.psa;

public abstract class Child {
    protected String childType;
    protected double height;
    protected double weight;
    protected String bloodType;
    protected int age;

    protected abstract void smile();

    protected abstract void cry();

    protected abstract void sleep();

    protected abstract void eat();
}
