package com.proptiger.mortgage.web.service;

import com.proptiger.mortgage.dao.MortgagePartnersDao;
import com.proptiger.mortgage.model.MortgagePartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.HashMap;
import java.util.Map;

@Service
public class MortgagePartnersService {

    @Autowired
    MortgagePartnersDao mortgagePartnersDao;

    public Map<String, Object> createPartner(Map<String, Object> params){
        Integer opportunityId = null;
        Double percentageShare = null;
        String profileUuid = null;

        MortgagePartner partner = MortgagePartner.builder()
                .opportunityId(opportunityId)
                .percentageShare(percentageShare)
                .profileUuid(profileUuid)
                .build();
        try {
            partner = mortgagePartnersDao.save(partner);
        } catch (Exception e) {

        }

        Map<String, Object> response = new HashMap<>();
        response.put("id", partner.getId());
        response.put("message", "SUCCESS");

        return response;
    }

    public void getOnBoardingStatus(){
        //Integer mortgagePartnerId
    }
}
