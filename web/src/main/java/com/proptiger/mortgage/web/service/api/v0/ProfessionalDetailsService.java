package com.proptiger.mortgage.web.service.api.v0;

import com.proptiger.mortgage.dao.ProfessionalDetailsDao;
import com.proptiger.mortgage.model.ProfessionalDetails;
import com.proptiger.mortgage.util.helpers.api.v0.ProfessionalDetailsServiceHelper;
import com.proptiger.pyro.core.constants.ResponseCodes;
import com.proptiger.pyro.core.exception.BadRequestException;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.CreateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.GetProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.UpdateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.response.api.v0.professionalDetails.ProfessionalDetailsResponseDTO;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalDetailsService {


    @Autowired
    private ProfessionalDetailsDao professionalDetailsDao;

    @Autowired
    private ProfessionalDetailsServiceHelper professionalDetailsServiceHelper;

    @Transactional
    public ProfessionalDetailsResponseDTO create(CreateProfessionalDetailsRequestDTO requestDTO) {

        ProfessionalDetails professionalDetails = professionalDetailsServiceHelper.toProfessionalDetail(
            requestDTO);

        professionalDetailsDao.save(professionalDetails);
        //after this, professionalDetails will have an id, which needs to be stored in mortgage_partner table

        return professionalDetailsServiceHelper.toProfessionalDetailsResponseDTO(
            professionalDetails);
    }

    public ProfessionalDetailsResponseDTO update(Integer id,
        UpdateProfessionalDetailsRequestDTO requestDTO) {
        //todo:implement this
        Optional<ProfessionalDetails> professionalDetailsOpt = professionalDetailsDao.findById(id);
        if (professionalDetailsOpt.isEmpty()) {
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, "Invalid id provided");
        }

        ProfessionalDetails professionalDetails = professionalDetailsOpt.get();

        professionalDetailsServiceHelper.updateProfessionalDetails(professionalDetails, requestDTO);

        professionalDetailsDao.save(professionalDetails);

        return professionalDetailsServiceHelper.toProfessionalDetailsResponseDTO(
            professionalDetails);
    }

    public ProfessionalDetailsResponseDTO get(
        GetProfessionalDetailsRequestDTO getProfessionalDetailsRequestDTO) {
        Optional<ProfessionalDetails> professionalDetailsOpt = Optional.empty();
        if (getProfessionalDetailsRequestDTO.getId() != null) {
            professionalDetailsOpt = professionalDetailsDao.findById(
                getProfessionalDetailsRequestDTO.getId());

        } else {
            //todo: add query by joining with mortgage_partner table
        }

        if (professionalDetailsOpt.isEmpty()) {
            throw new BadRequestException(ResponseCodes.BAD_REQUEST, "Invalid params provided");
        }

        ProfessionalDetails professionalDetails = professionalDetailsOpt.get();

        return professionalDetailsServiceHelper.toProfessionalDetailsResponseDTO(
            professionalDetails);
    }

}
