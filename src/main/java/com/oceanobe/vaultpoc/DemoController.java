package com.oceanobe.vaultpoc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${api-key}")
    private String apiKey;

    @GetMapping("/payment")
    public String getVaultSecrets() {
        return "API Key: " + apiKey;
    }
}
