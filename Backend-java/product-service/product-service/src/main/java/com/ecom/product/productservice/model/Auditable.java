package com.ecom.product.productservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Auditable<U> {

    @Column(name = "created_by",updatable = false)
    protected U createdBy;
    @Column(name = "created_date",updatable = false)
    protected LocalDateTime createdDate;
    @Column(name = "modified_by",insertable = false)
    protected U modifiedBy;
    @Column(name = "modified_date",insertable = false)
    protected LocalDateTime modifiedDate;
}
