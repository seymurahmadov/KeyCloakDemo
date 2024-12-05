package com.example.keyclocktest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@AuthenticationPrincipal(expression = "attributes") Map<String, Object> user) {
        return "Hello, " + user.get("preferred_username") + "!";
    }
}
