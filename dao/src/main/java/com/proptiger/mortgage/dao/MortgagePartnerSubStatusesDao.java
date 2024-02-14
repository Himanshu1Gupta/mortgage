package com.proptiger.mortgage.dao;

import com.proptiger.mortgage.model.MortgagePartnerSubStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MortgagePartnerSubStatusesDao extends JpaRepository<MortgagePartnerSubStatus, Integer> {

}