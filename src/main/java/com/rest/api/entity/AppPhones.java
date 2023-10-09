package com.rest.api.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "app_phones")
@Data
public class AppPhones implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "phone_id", nullable = false)
	private String phoneId;
	@Basic(optional = false)
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	@Basic(optional = false)
	@Column(name = "phone_citycode", nullable = false)
	private String phoneCitycode;
	@Basic(optional = false)
	@Column(name = "phone_contrycode", nullable = false)
	private String phoneContrycode;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@ManyToOne(optional = false)
	private AppUsers userId;

}
