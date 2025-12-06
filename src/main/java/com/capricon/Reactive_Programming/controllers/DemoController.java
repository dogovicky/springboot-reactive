package com.capricon.Reactive_Programming.controllers;

import com.capricon.Reactive_Programming.services.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class DemoController {


    private final DemoService demoService;

    @GetMapping("/demo")
    public Mono<String> fluxDemo() {
        return demoService
                .getMessage().zipWith(demoService.getNameFromDB())
                .map(value -> {
                    return value.getT1() + " " + value.getT2();
                });
    }

}
