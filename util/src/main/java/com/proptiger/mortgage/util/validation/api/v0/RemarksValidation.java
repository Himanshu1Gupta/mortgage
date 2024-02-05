package com.proptiger.mortgage.util.validation.api.v0;

import com.proptiger.pyro.core.constants.ResponseCodes;
import com.proptiger.pyro.core.exception.BadRequestException;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.CreateRemarkRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.GetLatestRemarkRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.GetPossibleRemarksRequestDTO;
import java.util.ArrayList;
import java.util.List;

public class RemarksValidation {

    public static void validateCreateRemarksRequest(CreateRemarkRequestDTO requestDTO) {
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

    public static void validateGetLatestRemarkRequest(GetLatestRemarkRequestDTO requestDTO) {
        if (requestDTO == null || requestDTO.getMortgagePartnerId() == null) {
            throw new BadRequestException(ResponseCodes.BAD_REQUEST,
                "mortgagePartnerId is mandatory");
        }
        if (requestDTO.getRemarkTypeId() == null) {
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, "RemarkTypeId is mandatory");
        }
        //todo:implement this method, add more validations
    }

    public static void validateGetPossibleRemarksRequest(GetPossibleRemarksRequestDTO requestDTO) {
        if (requestDTO == null || requestDTO.getRemarkTypeId() == null) {
            throw new BadRequestException(ResponseCodes.BAD_REQUEST,
                "RemarkTypeId is mandatory");
        }
    }
}
