package com.proptiger.mortgage.web.service.api.v0;

import com.proptiger.mortgage.dao.PossibleRemarksDao;
import com.proptiger.mortgage.dao.RemarksDao;
import com.proptiger.mortgage.model.PossibleRemarks;
import com.proptiger.mortgage.model.Remarks;
import com.proptiger.mortgage.util.helpers.api.v0.RemarksServiceHelper;
import com.proptiger.pyro.core.constants.ResponseCodes;
import com.proptiger.pyro.core.exception.BadRequestException;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.CreateRemarkRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.GetLatestRemarkRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.remarks.GetPossibleRemarksRequestDTO;
import com.proptiger.pyro.mortgage.response.api.v0.remarks.GetPossibleRemarksResponseDTO;
import com.proptiger.pyro.mortgage.response.api.v0.remarks.RemarkResponseDTO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemarksService {


    @Autowired
    private RemarksDao remarksDao;

    @Autowired
    private PossibleRemarksDao possibleRemarksDao;

    @Autowired
    private RemarksServiceHelper remarksServiceHelper;

    @Transactional
    public RemarkResponseDTO createRemarks(CreateRemarkRequestDTO requestDTO) {
        Remarks remarks = remarksServiceHelper.toRemarks(requestDTO);
        remarksDao.save(remarks);
        //update status of mortgage partner to rejected
        //notify the mortgage partner and sales rep

        return remarksServiceHelper.toRemarkResponseDTO(remarks);
    }

    public RemarkResponseDTO getLatestRemarks(GetLatestRemarkRequestDTO getLatestRemarkRequestDTO) {
        Optional<Remarks> remarksOpt = remarksDao.findFirstByMortgagePartnerIdAndRemarkTypeIdOrderByIdDesc(
            getLatestRemarkRequestDTO.getMortgagePartnerId(),getLatestRemarkRequestDTO.getRemarkTypeId());
        if(remarksOpt.isEmpty()){
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, "Remarks does not exist for the parameters");
        }

        Remarks remarks = remarksOpt.get();
        return remarksServiceHelper.toRemarkResponseDTO(remarks);
    }

    public GetPossibleRemarksResponseDTO getPossibleRemarks(
        GetPossibleRemarksRequestDTO requestDTO) {
        List<PossibleRemarks> possibleRemarks = possibleRemarksDao.findAllByRemarkTypeId(
            requestDTO.getRemarkTypeId());

        List<String> possibleRemarksText = possibleRemarks
            .stream()
            .map(possibleRemark -> possibleRemark.getText())
            .collect(Collectors.toList());

        return GetPossibleRemarksResponseDTO.builder().possibleRemarks(possibleRemarksText).build();
    }
}
