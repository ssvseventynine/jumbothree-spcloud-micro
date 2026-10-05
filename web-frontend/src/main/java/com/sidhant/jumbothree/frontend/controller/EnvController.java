package com.sidhant.jumbothree.frontend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

    // Reads GATEWAY_URL from Azure/System environment variables. 
    // Defaults to localhost:9090 if it's not found (like when running in Eclipse).
    @Value("${GATEWAY_URL:http://localhost:9090}")
    private String gatewayUrl;

    @GetMapping(value = "/env.js", produces = "application/javascript")
    public String getEnvJs() {
        return "window.env = { GATEWAY_URL: '" + gatewayUrl + "' };";
    }
}