package com.proptiger.mortgage.web.service.api.v0;

import com.proptiger.mortgage.dao.ProfessionalDetailsDao;
import com.proptiger.mortgage.dao.RemarksDao;
import com.proptiger.mortgage.model.ProfessionalDetails;
import com.proptiger.mortgage.model.Remarks;
import com.proptiger.mortgage.util.helpers.api.v0.ProfessionalDetailsServiceHelper;
import com.proptiger.mortgage.util.helpers.api.v0.RemarksServiceHelper;
import com.proptiger.pyro.core.constants.ResponseCodes;
import com.proptiger.pyro.core.exception.BadRequestException;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.CreateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.GetProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.UpdateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.CreateRemarkRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.GetRemarkRequestDTO;
import com.proptiger.pyro.mortgage.response.api.v0.professionalDetails.ProfessionalDetailsResponseDTO;
import com.proptiger.pyro.mortgage.response.api.v0.remarks.RemarkResponseDTO;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemarksService {


    @Autowired
    private RemarksDao remarksDao;

    @Autowired
    private RemarksServiceHelper remarksServiceHelper;

    @Transactional
    public RemarkResponseDTO create(CreateRemarkRequestDTO requestDTO) {
        Remarks remarks = remarksServiceHelper.toRemarks(requestDTO);
        remarksDao.save(remarks);
        //update status of mortgage partner to rejected
        //notify the mortgage partner and sales rep

        return remarksServiceHelper.toRemarkResponseDTO(remarks);
    }

    public Object get(GetRemarkRequestDTO getRemarkRequestDTO) {
        Optional<Remarks> remarksOpt = remarksDao.findFirstByMortgagePartnerIdAndRemarkTypeIdOrderByIdDesc(
            getRemarkRequestDTO.getMortgagePartnerId(),getRemarkRequestDTO.getRemarkTypeId());
        if(remarksOpt.isEmpty()){
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, "Invalid id provided");
        }

        Remarks remarks = remarksOpt.get();
        return remarksServiceHelper.toRemarkResponseDTO(remarks);
    }
}
