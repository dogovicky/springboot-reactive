package com.capricon.Reactive_Programming.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class DemoService {

    public Mono<String> getMessage() {
        return Mono.just("Hello Reactive World").delayElement(Duration.ofSeconds(5));
    }

    public Mono<String> getNameFromDB() {
        return Mono.just("Capricon").delayElement(Duration.ofSeconds(5));
    }

}
