package com.proptiger.mortgage.util.validation.api.v0;

import com.proptiger.mortgage.util.constants.Keys;
import com.proptiger.pyro.core.constants.ResponseCodes;
import com.proptiger.pyro.core.exception.BadRequestException;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.CreateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.GetProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.UpdateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.CreateRemarkRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.GetRemarkRequestDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RemarksValidation {

    public static void validateCreateRequest(CreateRemarkRequestDTO requestDTO) {
        if(requestDTO == null){
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, "Request body is empty");
        }

        List<String> errors = new ArrayList<>();
        if(requestDTO.getRemark() == null || requestDTO.getRemark().isEmpty()){
            errors.add("remark cannot be empty");
        }
        if(requestDTO.getRemarkTypeId() == null){
            errors.add("remarkTypeId cannot be empty");
        }
        if(requestDTO.getMortgagePartnerId() == null){
            errors.add("mortgagePartnerId cannot be empty");
        }

        if(!errors.isEmpty()){
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, String.join(", ", errors));
        }

        //todo:implement this method, add more validations
    }

    public static void validateGetRequest(GetRemarkRequestDTO requestDTO) {
        if (requestDTO == null || requestDTO.getMortgagePartnerId() == null) {
            throw new BadRequestException(ResponseCodes.BAD_REQUEST,
                "mortgagePartnerId is mandatory");
        }
        if (requestDTO.getRemarkTypeId() == null) {
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, "RemarkTypeId is mandatory");
        }
        //todo:implement this method, add more validations
    }
}
