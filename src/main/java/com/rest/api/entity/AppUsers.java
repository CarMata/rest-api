package com.rest.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="app_users")
@Data
public class AppUsers implements Serializable{
	   private static final long serialVersionUID = 1L;
	    @Id
	    @Basic(optional = false)
	    @Column(name = "user_id", nullable = false)
	    private String userId;
	    @Basic(optional = false)
	    @Column(name = "user_name", nullable = false)
	    private String userName;
	    @Basic(optional = false)
	    @Column(name = "user_email", nullable = false)
	    private String userEmail;
	    @Basic(optional = false)
	    @Column(name = "user_password", nullable = false)
	    private String userPassword;
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	    private List<AppPhones> appPhonesList;
}
