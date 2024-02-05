package com.proptiger.mortgage.dao;

import com.proptiger.mortgage.model.PossibleRemarks;
import com.proptiger.mortgage.model.Remarks;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PossibleRemarksDao extends JpaRepository<PossibleRemarks, Integer> {

    List<PossibleRemarks> findAllByRemarkTypeId(int remarkTypeId);
}
