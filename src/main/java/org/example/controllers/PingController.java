package org.example.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
@RequiredArgsConstructor
@Slf4j
public class PingController {

    @GetMapping("")
    public String ping() {
        log.info("ping");
        return "OK";
    }
}
