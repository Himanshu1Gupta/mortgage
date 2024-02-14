package com.proptiger.mortgage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mortgage_partners")
public class MortgagePartner implements Serializable {
    private static final long serialVersionUID = 6201760278790884141L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String profileUuid;

    @Column(nullable = false)
    private Integer opportunityId;

    @Column(nullable = false)
    private Double percentageShare;

    private Integer professionalDetailsId;

    private Integer bankDetailsId;

    private Integer serviceAgreementId;

    private Integer onBoardingStatusId;

    private Integer onBoardingSubStatusId;

    private Integer parentId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @PrePersist
    private void prePersist() {
        createdAt = new Date();
        updatedAt = createdAt;
    }

    @PreUpdate
    private void preUpdate() {
        updatedAt = new Date();
    }
}


