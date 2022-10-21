/**
 * 
 */
package com.hacorp.authen.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "User_role")
public class UserRole extends Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1081804444692204918L;

	private Long id;
	private Role role;
	private User user;

	
	public UserRole() {
		super();
	}
	
	public UserRole(Long id, Role role, User user) {
		super();
		this.id = id;
		this.role = role;
		this.user = user;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "role_code")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name = "user_name")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
