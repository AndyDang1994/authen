package com.hacorp.authen.core.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hacorp.authen.repository.service.RoleRepositoryService;
import com.hacorp.authen.repository.service.UserRepositoryService;
import com.hacorp.authen.repository.service.UserRoleRepositoryService;

@Service("repositoryManagerService")
public class RepositoryManagerService extends AbstractBasicCommonClass{
	
	@Autowired
	private RoleRepositoryService roleRepositoryService;
	
	@Autowired
	private UserRepositoryService userRepositoryService;
	
	@Autowired
	private UserRoleRepositoryService userRoleRepositoryService;

	public RoleRepositoryService getRoleRepositoryService() {
		return roleRepositoryService;
	}

	public void setRoleRepositoryService(
		@Qualifier("roleRepositoryService")	RoleRepositoryService roleRepositoryService) {
		this.roleRepositoryService = roleRepositoryService;
	}

	public UserRepositoryService getUserRepositoryService() {
		return userRepositoryService;
	}

	public void setUserRepositoryService(
		@Qualifier("userRepositoryService")	UserRepositoryService userRepositoryService) {
		this.userRepositoryService = userRepositoryService;
	}

	public UserRoleRepositoryService getUserRoleRepositoryService() {
		return userRoleRepositoryService;
	}

	public void setUserRoleRepositoryService(
			@Qualifier("userRoleRepositoryService")	UserRoleRepositoryService userRoleRepositoryService) {
		this.userRoleRepositoryService = userRoleRepositoryService;
	}
	

}
