package com.proptiger.mortgage.web.controller.api.v0;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proptiger.mortgage.util.validation.api.v0.RemarksValidation;
import com.proptiger.mortgage.web.service.api.v0.RemarksService;
import com.proptiger.pyro.common.pojo.response.APIResponse;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.CreateRemarkRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.GetLatestRemarkRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.GetPossibleRemarksRequestDTO;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v0")
@RestController
public class RemarksController {

    @Autowired private ObjectMapper objectMapper;

    @Autowired
    private RemarksService remarksService;

    @PostMapping(value = "/remarks")
    public APIResponse createRemarks(
        @RequestBody CreateRemarkRequestDTO requestDTO) {
        RemarksValidation.validateCreateRemarksRequest(requestDTO);
        return new APIResponse(remarksService.createRemarks(requestDTO));
    }


    @GetMapping("/latest-remarks")
    public APIResponse getLatestRemarks(
        @RequestParam Map<String, String> params) {
        GetLatestRemarkRequestDTO getLatestRemarkRequestDTO =
            objectMapper.convertValue(params, GetLatestRemarkRequestDTO.class);
        RemarksValidation.validateGetLatestRemarkRequest(getLatestRemarkRequestDTO);
        return new APIResponse(remarksService.getLatestRemarks(getLatestRemarkRequestDTO));
    }

    @GetMapping("/possible-remarks")
    public APIResponse getPossibleRemarks(
        @RequestParam Map<String, String> params) {
        GetPossibleRemarksRequestDTO getPossibleRemarksRequestDTO =
            objectMapper.convertValue(params, GetPossibleRemarksRequestDTO.class);
        RemarksValidation.validateGetPossibleRemarksRequest(getPossibleRemarksRequestDTO);
        return new APIResponse(remarksService.getPossibleRemarks(getPossibleRemarksRequestDTO));
    }

}
