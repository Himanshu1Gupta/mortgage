package com.proptiger.mortgage.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "professional_details")
public class ProfessionalDetails implements Serializable {
    private static final long serialVersionUID = 7700148590085921283L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mortgage_partner_id",nullable = false)
    private Integer mortgagePartnerId;

    @Column(name = "pan_number",nullable = false)
    private String panNumber;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "mobile_number",nullable = false)
    private String mobileNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "gst_number")
    private String gstNumber;

    @Column(name = "legal_name_of_organization")
    private String legalNameOfOrganization;

    @Column(name = "trade_of_the_organization")
    private String tradeOfTheOrganization;

    @Column(name = "address_of_the_organization")
    private String addressOfTheOrganization;

    @Column(name = "state_of_the_organization")
    private String stateOfTheOrganization;

    @Column(name = "pin_code_of_the_organization")
    private String pinCodeOfTheOrganization;

    @Column(name = "aadhar_card_url")
    private String aadharCardUrl;

    @Column(name = "gst_certificate_url")
    private String gstCertificateUrl;

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
