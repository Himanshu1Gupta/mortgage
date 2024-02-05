package com.proptiger.mortgage.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="remarks")
@Builder
@TypeDef(name = "json", typeClass = JsonType.class)
public class Remarks implements Serializable {
    private static final long serialVersionUID = 7700148590085921283L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Type(type = "json")
    @Column(name = "remark", columnDefinition = "json")
    private Map<String, Object> remark;

    @Column(name = "remark_type_id",nullable = false)
    private Integer remarkTypeId;

    @Column(name = "mortgage_partner_id",nullable = false)
    private Integer mortgagePartnerId;

    @ManyToOne
    @JoinColumn(name = "remark_type_id", insertable = false, updatable = false)
    private RemarkTypes remarkTypes;

    //todo: uncomment this, once mortgage_partner table is created
//    @ManyToOne
//    @JoinColumn(name = "mortgage_partner_id", insertable = false, updatable = false)
//    private MortgagePartner mortgagePartner;


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
