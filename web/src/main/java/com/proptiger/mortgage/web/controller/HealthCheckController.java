package com.proptiger.mortgage.web.controller;

import com.proptiger.mortgage.dao.MortgagePartnerOnboardingStatusesDao;
import com.proptiger.pyro.common.pojo.response.APIResponseGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    @Autowired
    MortgagePartnerOnboardingStatusesDao statusesDao;

    @GetMapping("/ping")
    public APIResponseGeneric<String> ping() {
        return new APIResponseGeneric<>("pong");
    }

    @GetMapping("/healthcheck")
    public APIResponseGeneric<Map<String, Object>> healthcheck() {
        Map<String, Object> healthCheckResponse = new HashMap<>();
        healthCheckResponse.put("application", "Postgres");
        healthCheckResponse.put("status", statusesDao.findFirstByOrderById()!=null);
        return new APIResponseGeneric<>(healthCheckResponse);
    }

}
