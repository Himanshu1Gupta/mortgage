package com.proptiger.mortgage.dao;

import com.proptiger.mortgage.model.ProfessionalDetails;
import com.proptiger.mortgage.model.Remarks;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemarksDao extends JpaRepository<Remarks, Integer> {

    Optional<Remarks> findFirstByMortgagePartnerIdAndRemarkTypeIdOrderByIdDesc(Integer mortgagePartnerId, Integer remarkTypeId);

    List<Remarks> findAllByMortgagePartnerIdAndRemarkTypeIdOrderByIdDesc(Integer mortgagePartnerId, Integer remarkTypeId);

}
