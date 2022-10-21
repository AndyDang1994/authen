/**
 * 
 */
package com.hacorp.authen.repository.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "user")
public class User extends Base{

	private String userName;
	private String password;
	private String status;
	private String email;
	private String masterUserName;
	private List<UserRole> userRoles;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String password, String status, String masterUserName, Date regisDate,
			String regisBy, Date lchgDate, String lchgBy, List<UserRole> userRoles) {
		super();
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.masterUserName = masterUserName;
		this.userRoles = userRoles;
	}
	
	public User(String userName, String password, String status, String email, String masterUserName,
			List<UserRole> userRoles) {
		super();
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.email = email;
		this.masterUserName = masterUserName;
		this.userRoles = userRoles;
	}

	@Id
	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonIgnore
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "master_username")
	public String getMasterUserName() {
		return masterUserName;
	}

	public void setMasterUserName(String masterUserName) {
		this.masterUserName = masterUserName;
	}
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
