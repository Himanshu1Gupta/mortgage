package com.proptiger.mortgage.dao;

import com.proptiger.mortgage.model.MortgagePartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgagePartnersDao extends JpaRepository<MortgagePartner, Integer> {

}
