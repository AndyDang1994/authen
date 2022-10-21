package com.hacorp.authen.repository.service;

import java.util.List;
import java.util.Map;

import com.hacorp.authen.core.exception.BaseException;
import com.hacorp.authen.repository.entity.Role;

public interface RoleRepositoryService extends BaseRepositoryService{
	
	public Role getRoleByRoleCode(Map<String, Object> inputParams) throws BaseException;

	public List<Role> getListRoleByRoleCode(Map<String, Object> inputParams) throws BaseException;


}
