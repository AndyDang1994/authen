package com.hacorp.authen.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "screen_role")
public class ScreenRole extends Base {
	
	private Long id;
	private String screenName;
	private Role role;
	private String screenCofig;
	public ScreenRole() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "screen_name")
	public String getScreenName() {
		return screenName;
	}


	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	@ManyToOne
	@JoinColumn(name = "role_code")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "screen_config")
	public String getScreenCofig() {
		return screenCofig;
	}
	public void setScreenCofig(String screenCofig) {
		this.screenCofig = screenCofig;
	}

	
}
