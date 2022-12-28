package com.codestates.example;

import reactor.core.publisher.Flux;

public class MarbleDiagramExample {
    public static void main(String[] args) {
        Flux
                .just("Green-Circle", "Orange-Circle", "Blue-Circle")
                .map(figure -> figure.replace("circle","Rectangle"))
                .subscribe(System.out::println);
    }
}