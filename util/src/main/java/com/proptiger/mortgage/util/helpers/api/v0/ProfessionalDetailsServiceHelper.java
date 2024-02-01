package com.proptiger.mortgage.util.helpers.api.v0;

import com.proptiger.mortgage.model.ProfessionalDetails;
import com.proptiger.pyro.mortgage.response.api.v0.professionalDetails.ProfessionalDetailsResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfessionalDetailsServiceHelper {

    public ProfessionalDetailsResponseDTO toProfessionalDetailsResponseDTO(ProfessionalDetails professionalDetails, Integer mortgagePartnerId) {
        return ProfessionalDetailsResponseDTO.builder()
            .Id(professionalDetails.getId())
            .mortgagePartnerId(mortgagePartnerId)
            .panNumber(professionalDetails.getPanNumber())
            .name(professionalDetails.getName())
            .mobileNumber(professionalDetails.getMobileNumber())
            .emailAddress(professionalDetails.getEmailAddress())
            .gstNumber(professionalDetails.getGstNumber())
            .legalNameOfOrganization(professionalDetails.getLegalNameOfOrganization())
            .tradeOfTheOrganization(professionalDetails.getTradeOfTheOrganization())
            .addressOfTheOrganization(professionalDetails.getAddressOfTheOrganization())
            .stateOfTheOrganization(professionalDetails.getStateOfTheOrganization())
            .pinCodeOfTheOrganization(professionalDetails.getPinCodeOfTheOrganization())
            .build();
    }
}
