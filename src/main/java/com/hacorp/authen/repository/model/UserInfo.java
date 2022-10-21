/**
 * 
 */
package com.hacorp.authen.repository.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hacorp.authen.core.exception.ServiceRuntimeException;
import com.hacorp.authen.core.utils.CommonUtil;
import com.hacorp.authen.repository.entity.UserRole;

public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String fullname;
	private String status;
	private String email;
	private String token;
	private Object roles;
	private Object authenFeature;
	private Object screenRole;

	/**
	 * 
	 */
	public UserInfo() {
		super();
		this.roles = new ArrayList<>();
		this.authenFeature = new ArrayList<>();
		this.screenRole = new ArrayList<>();
	}
	public UserInfo(String userName,String fullname,String status,String email,List<UserRole> userRoles) {
		super();
		List<String> roles = new ArrayList<>();
		List<AuthenFeatureInforModel> roleFeatures = new ArrayList<>();
		this.userName = userName;
		this.fullname = fullname;
		this.status = status;
		this.email = email;
		this.roles = roles;
		this.authenFeature = roleFeatures;
		for (UserRole usRole : userRoles) {
			try {
				roleFeatures.add((AuthenFeatureInforModel) CommonUtil.toPojo(usRole.getRole().getRoleConfig(), AuthenFeatureInforModel.class ));
			} catch (ServiceRuntimeException e) {
				e.printStackTrace();
			}
			roles.add(usRole.getRole().getRoleCode());
		}
	}
	
	/**
	 * @param userName
	 * @param password
	 */
	public UserInfo(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @param userName
	 * @param roles
	 */
	public UserInfo(String userName, Object roles) {
		super();
		this.userName = userName;
		this.roles = roles;
	}

	/**
	 * @param userName
	 * @param status
	 * @param roles
	 */
	public UserInfo(String userName, String status, Object roles) {
		super();
		this.userName = userName;
		this.status = status;
		this.roles = roles;
	}

	/**
	 * @param userName
	 * @param fullname
	 * @param status
	 * @param roles
	 */
	public UserInfo(String userName, String fullname, String status, Object roles) {
		super();
		this.userName = userName;
		this.fullname = fullname;
		this.status = status;
		this.roles = roles;
	}

	/**
	 * @param token
	 */
	public UserInfo(String token) {
		super();
		this.token = token;
		this.roles = new ArrayList<UserRole>();
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the roles
	 */
	public Object getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Object roles) {
		this.roles = roles;
	}

	public Object getAuthenFeature() {
		return authenFeature;
	}

	public void setAuthenFeature(Object authenFeature) {
		this.authenFeature = authenFeature;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Object getScreenRole() {
		return screenRole;
	}
	public void setScreenRole(Object screenRole) {
		this.screenRole = screenRole;
	}
	
}
