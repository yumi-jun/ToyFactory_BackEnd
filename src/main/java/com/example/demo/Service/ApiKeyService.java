package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyService {



    private String apiKey;


    public String getApiKey() {
        return apiKey;
    }


}