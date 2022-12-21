package com.codestates.chapter2.di.psa;

public class ChildManageApplication {
    public static void main(String[] args) {
        Child newBornBaby = new NewBornBaby(); // (1)
        Child infant = new Infant(); // (2)
        Child toddler = new Toddler(); // (3)

        newBornBaby.sleep();
        infant.sleep();
        toddler.sleep();
        toddler.cry();
        toddler.smile();
    }
}