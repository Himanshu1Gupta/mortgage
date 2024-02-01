package com.proptiger.mortgage.dao;

import com.proptiger.mortgage.model.MortgagePartnerOnboardingStatus;
import com.proptiger.mortgage.model.ProfessionalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalDetailsDao extends JpaRepository<ProfessionalDetails, Integer> {

    ProfessionalDetails findFirstByOrderById();
}
