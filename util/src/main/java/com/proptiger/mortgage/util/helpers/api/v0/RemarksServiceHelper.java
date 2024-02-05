package com.proptiger.mortgage.util.helpers.api.v0;

import com.proptiger.mortgage.model.ProfessionalDetails;
import com.proptiger.mortgage.model.Remarks;
import com.proptiger.mortgage.util.CommonUtil;
import com.proptiger.mortgage.util.constants.Keys;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.CreateRemarkRequestDTO;
import com.proptiger.pyro.mortgage.response.api.v0.professionalDetails.ProfessionalDetailsResponseDTO;
import com.proptiger.pyro.mortgage.response.api.v0.remarks.RemarkResponseDTO;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class RemarksServiceHelper {

    public Remarks toRemarks(CreateRemarkRequestDTO requestDTO) {
        //todo:implement this
        return Remarks
            .builder()
            .remark(requestDTO.getRemark())
            .remarkTypeId(requestDTO.getRemarkTypeId())
            .mortgagePartnerId(requestDTO.getMortgagePartnerId())
            .build();
    }

    public RemarkResponseDTO toRemarkResponseDTO(Remarks remarks) {
        //TODO: implement this
        return RemarkResponseDTO
            .builder()
            .Id(remarks.getId())
            .mortgagePartnerId(remarks.getMortgagePartnerId())
            .remark(remarks.getRemark())
            .remarkTypeId(remarks.getRemarkTypeId())
            .remarkType(CommonUtil.getValue(() -> remarks.getRemarkTypes().getRemarkType(),
                Keys.EMPTY_STRING))
            .build();
    }
}
