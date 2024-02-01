package com.proptiger.mortgage.web.controller.api.v0;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proptiger.mortgage.util.validation.api.v0.ProfessionalDetailsValidation;
import com.proptiger.mortgage.util.validation.api.v0.RemarksValidation;
import com.proptiger.mortgage.web.service.api.v0.ProfessionalDetailsService;
import com.proptiger.mortgage.web.service.api.v0.RemarksService;
import com.proptiger.pyro.common.pojo.response.APIResponse;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.CreateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.GetProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.UpdateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.CreateRemarkRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.GetRemarkRequestDTO;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public APIResponse create(
        @RequestBody CreateRemarkRequestDTO requestDTO) {
        RemarksValidation.validateCreateRequest(requestDTO);
        return new APIResponse(remarksService.create(requestDTO));
    }


    @GetMapping("/remarks")
    public APIResponse get(
        @RequestParam Map<String, String> params) {
        GetRemarkRequestDTO getRemarkRequestDTO =
            objectMapper.convertValue(params, GetRemarkRequestDTO.class);
        RemarksValidation.validateGetRequest(getRemarkRequestDTO);
        return new APIResponse(remarksService.get(getRemarkRequestDTO));
    }

}
