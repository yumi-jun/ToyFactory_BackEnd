package com.example.demo.Controller;

import com.example.demo.Service.ApiKeyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    public ApiKeyController(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @GetMapping("/api-key")
    public String getApiKey() {
        return apiKeyService.getApiKey();
    }


}