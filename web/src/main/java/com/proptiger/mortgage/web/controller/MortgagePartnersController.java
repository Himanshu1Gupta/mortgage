package com.proptiger.mortgage.web.controller;

import com.proptiger.mortgage.web.service.MortgagePartnersService;
import com.proptiger.pyro.common.pojo.response.APIResponseGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MortgagePartnersController {

    @Autowired
    private MortgagePartnersService mortgagePartnersService;

    @PostMapping("/partner/create")
    public APIResponseGeneric<HashMap<String, Object>> createPartner(@RequestBody Map<String, Object> params){
        return new APIResponseGeneric<>((HashMap<String, Object>)mortgagePartnersService.createPartner(params));
    }

    @GetMapping("/partner/onboarding-status")
    public APIResponseGeneric<String> getOnBoardingStatus(
            @RequestParam Map<String, String> params) {
        return new APIResponseGeneric<>();
    }


}
