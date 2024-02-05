package com.proptiger.mortgage.util.helpers.api.v0;

import com.proptiger.mortgage.model.ProfessionalDetails;
import com.proptiger.mortgage.util.StringUtil;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.CreateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.request.api.v0.professionalDetails.UpdateProfessionalDetailsRequestDTO;
import com.proptiger.pyro.mortgage.response.api.v0.professionalDetails.ProfessionalDetailsResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfessionalDetailsServiceHelper {

    public ProfessionalDetailsResponseDTO toProfessionalDetailsResponseDTO(
        ProfessionalDetails professionalDetails, Integer mortgagePartnerId) {
        return ProfessionalDetailsResponseDTO
            .builder()
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
            .aadharCardUrl(professionalDetails.getAadharCardUrl())
            .gstCertificateUrl(professionalDetails.getGstCertificateUrl())
            .build();
    }

    public ProfessionalDetails toProfessionalDetail(
        CreateProfessionalDetailsRequestDTO requestDTO) {
        return ProfessionalDetails
            .builder()
            .panNumber(requestDTO.getPanNumber())
            .name(requestDTO.getName())
            .mobileNumber(requestDTO.getMobileNumber())
            .emailAddress(requestDTO.getEmailAddress())
            .gstNumber(requestDTO.getGstNumber())
            .legalNameOfOrganization(requestDTO.getLegalNameOfOrganization())
            .tradeOfTheOrganization(requestDTO.getTradeOfTheOrganization())
            .addressOfTheOrganization(requestDTO.getAddressOfTheOrganization())
            .stateOfTheOrganization(requestDTO.getStateOfTheOrganization())
            .pinCodeOfTheOrganization(requestDTO.getPinCodeOfTheOrganization())
            .aadharCardUrl(requestDTO.getAadharCardUrl())
            .gstCertificateUrl(requestDTO.getGstCertificateUrl())
            .build();
    }

    public void updateProfessionalDetails(ProfessionalDetails professionalDetails,
        UpdateProfessionalDetailsRequestDTO requestDTO) {

        if (!StringUtil.isNullOrEmpty(requestDTO.getPanNumber())) {
            professionalDetails.setPanNumber(requestDTO.getPanNumber());
        }
        if (!StringUtil.isNullOrEmpty(requestDTO.getName())) {
            professionalDetails.setName(requestDTO.getName());
        }
        if (!StringUtil.isNullOrEmpty(requestDTO.getMobileNumber())) {
            professionalDetails.setMobileNumber(requestDTO.getMobileNumber());
        }
        if (!StringUtil.isNullOrEmpty(requestDTO.getEmailAddress())) {
            professionalDetails.setEmailAddress(requestDTO.getEmailAddress());
        }
        if (!StringUtil.isNullOrEmpty(requestDTO.getGstNumber())) {
            professionalDetails.setGstNumber(requestDTO.getGstNumber());
        }
        if (!StringUtil.isNullOrEmpty(requestDTO.getLegalNameOfOrganization())) {
            professionalDetails.setLegalNameOfOrganization(requestDTO.getLegalNameOfOrganization());
        }
        if (!StringUtil.isNullOrEmpty(requestDTO.getTradeOfTheOrganization())) {
            professionalDetails.setTradeOfTheOrganization(requestDTO.getTradeOfTheOrganization());
        }
        if (!StringUtil.isNullOrEmpty(requestDTO.getAddressOfTheOrganization())) {
            professionalDetails.setAddressOfTheOrganization(
                requestDTO.getAddressOfTheOrganization());
        }
        if (!StringUtil.isNullOrEmpty(requestDTO.getStateOfTheOrganization())) {
            professionalDetails.setStateOfTheOrganization(requestDTO.getStateOfTheOrganization());
        }
        if (!StringUtil.isNullOrEmpty(requestDTO.getPinCodeOfTheOrganization())) {
            professionalDetails.setPinCodeOfTheOrganization(
                requestDTO.getPinCodeOfTheOrganization());
        }
        if (!StringUtil.isNullOrEmpty(requestDTO.getAadharCardUrl())) {
            professionalDetails.setAadharCardUrl(requestDTO.getAadharCardUrl());
        }
        if (!StringUtil.isNullOrEmpty(requestDTO.getGstCertificateUrl())) {
            professionalDetails.setGstCertificateUrl(requestDTO.getGstCertificateUrl());
        }
    }
}
