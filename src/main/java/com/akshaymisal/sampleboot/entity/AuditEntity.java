package com.akshaymisal.sampleboot.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class AuditEntity {

	@CreatedDate
	@Column(updatable = false)
	private Date createdAt;

	@CreatedBy
	@Column(updatable = false)
	private Integer createdBy;

	@LastModifiedDate
	@Column(insertable = false)
	private Date updatedAt;

	@LastModifiedBy
	@Column(insertable = false)
	private Integer updatedBy;

}
