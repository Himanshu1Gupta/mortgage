package com.proptiger.mortgage.web.controller;

import com.proptiger.pyro.common.pojo.response.APIResponseGeneric;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/ping")
    public APIResponseGeneric<String> ping() {
        return new APIResponseGeneric<>("pong");
    }

}
