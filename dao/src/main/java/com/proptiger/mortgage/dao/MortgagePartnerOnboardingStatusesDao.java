package com.proptiger.mortgage.dao;

import com.proptiger.mortgage.model.MortgagePartnerOnboardingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgagePartnerOnboardingStatusesDao extends JpaRepository<MortgagePartnerOnboardingStatus, Integer> {

    MortgagePartnerOnboardingStatus findFirstByOrderById();
}
