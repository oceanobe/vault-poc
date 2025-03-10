package com.oceanobe.vaultpoc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${test}")
    private String test;

    @GetMapping("/vault")
    public String getVaultSecrets() {
        return "Test: " + test;
    }
}
