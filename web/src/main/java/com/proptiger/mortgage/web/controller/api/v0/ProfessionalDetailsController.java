package com.proptiger.mortgage.web.controller.api.v0;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proptiger.mortgage.web.service.api.v0.ProfessionalDetailsService;
import com.proptiger.pyro.common.pojo.response.APIResponse;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.CreateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.GetProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.UpdateProfessionalDetailsRequestDTO;
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

import com.proptiger.mortgage.util.validation.api.v0.ProfessionalDetailsValidation;

@RequestMapping("/api/v0")
@RestController
public class ProfessionalDetailsController {

    @Autowired private ObjectMapper objectMapper;

    @Autowired
    private ProfessionalDetailsService professionalDetailsService;

    @PostMapping(value = "/professional-details")
    public APIResponse create(
        @RequestBody CreateProfessionalDetailsRequestDTO requestDTO) {
        ProfessionalDetailsValidation.validateCreateRequest(requestDTO);
        return new APIResponse(professionalDetailsService.create(requestDTO));
    }

    @PutMapping(value = "/professional-details/{id}")
    public APIResponse update(@PathVariable Integer id,
        @RequestBody UpdateProfessionalDetailsRequestDTO requestDTO) {
        ProfessionalDetailsValidation.validateUpdateRequest(requestDTO);
        return new APIResponse(professionalDetailsService.update(id, requestDTO));
    }

    @GetMapping("/professional-details")
    public APIResponse get(
        @RequestParam Map<String, String> params) {
        GetProfessionalDetailsRequestDTO getProfessionalDetailsRequestDTO =
            objectMapper.convertValue(params, GetProfessionalDetailsRequestDTO.class);
        ProfessionalDetailsValidation.validateGetRequest(getProfessionalDetailsRequestDTO);
        return new APIResponse(professionalDetailsService.get(getProfessionalDetailsRequestDTO));
    }

}
