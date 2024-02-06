package com.proptiger.mortgage.util.validation.api.v0;

import com.proptiger.mortgage.util.StringUtil;
import com.proptiger.mortgage.util.constants.Keys;
import com.proptiger.pyro.core.constants.ResponseCodes;
import com.proptiger.pyro.core.exception.BadRequestException;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.CreateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.GetProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.UpdateProfessionalDetailsRequestDTO;
import java.util.ArrayList;
import java.util.List;

public class ProfessionalDetailsValidation {

    public static void validateCreateRequest(CreateProfessionalDetailsRequestDTO requestDTO) {
        String message = Keys.EMPTY_STRING;
        List<String> messages = new ArrayList<>();
        if(requestDTO == null) {
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, "Invalid param provided");
        }
        
        if(requestDTO.getMortgagePartnerId() == null) {
            messages.add("mortgage_partner_id is missing");
        }
        if(requestDTO.getPanNumber() == null) {
            messages.add("pan_number is missing");
        }
        
        if(!messages.isEmpty()) {
            message = String.join(", ", messages);
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, message);
        }
        
        //todo:implement this method, add more validations
    }

    public static void validateUpdateRequest(UpdateProfessionalDetailsRequestDTO requestDTO) {
        String message = Keys.EMPTY_STRING;
        List<String> messages = new ArrayList<>();
        if(requestDTO == null) {
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, "Invalid param provided");
        }

        if(requestDTO.getMortgagePartnerId() == null) {
            messages.add("mortgage_partner_id is missing");
        }
        if(requestDTO.getPanNumber() == null) {
            messages.add("pan_number is missing");
        }

        if(!messages.isEmpty()) {
            message = String.join(", ", messages);
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, message);
        }
        //todo:implement this method, add more validations
    }

    public static void validateGetRequest(
        GetProfessionalDetailsRequestDTO getProfessionalDetailsRequestDTO) {
        String message = Keys.EMPTY_STRING;
        List<String> messages = new ArrayList<>();
        if (getProfessionalDetailsRequestDTO == null) {
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, "Invalid param provided");
        }

        if (getProfessionalDetailsRequestDTO.getId() == null
            && getProfessionalDetailsRequestDTO.getMortgagePartnerId() == null
            && (StringUtil.isNullOrEmpty(getProfessionalDetailsRequestDTO.getOpportunityId())
            || StringUtil.isNullOrEmpty(getProfessionalDetailsRequestDTO.getProfileUuid()))) {
            messages.add(
                "either id or mortgage_partner_id or (opportunity_id and profile_uuid) must be passed");
        }

        if (!messages.isEmpty()) {
            message = String.join(", ", messages);
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, message);
        }
    }
}
