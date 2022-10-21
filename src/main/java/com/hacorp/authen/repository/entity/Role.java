package com.hacorp.authen.repository.entity;

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
@Table(name = "role")
public class Role extends Base {

	private String roleCode;
	private String roleConfig;
	private List< UserRole> userRole;
	private List<ScreenRole> screenRole;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Role(String roleCode, String roleConfig, List<UserRole> userRole) {
		super();
		this.roleCode = roleCode;
		this.roleConfig = roleConfig;
		this.userRole = userRole;
	}

	@Id
	@Column(name = "role_code")
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	@Column(name = "role_configure")
	public String getRoleConfig() {
		return roleConfig;
	}
	public void setRoleConfig(String roleConfig) {
		this.roleConfig = roleConfig;
	}

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.LAZY)
	public List<UserRole> getUserRole() {
		return userRole;
	}


	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}


	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<ScreenRole> getScreenRole() {
		return screenRole;
	}


	public void setScreenRole(List<ScreenRole> screenRole) {
		this.screenRole = screenRole;
	}
	
	
	
}
