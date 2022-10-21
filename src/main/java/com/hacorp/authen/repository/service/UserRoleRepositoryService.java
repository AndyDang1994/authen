package com.hacorp.authen.repository.service;

import java.util.List;
import java.util.Map;

import com.hacorp.authen.core.exception.BaseException;
import com.hacorp.authen.repository.entity.UserRole;


public interface UserRoleRepositoryService {

	public List<UserRole> getUserRoleByUserName(Map<String, Object> inputParams) throws BaseException;
	public boolean update(Map<String, Object> inputParams) throws BaseException;
	public boolean updateAll(Map<String, Object> inputParams) throws BaseException;
	public boolean save(Map<String, Object> inputParams) throws BaseException;
	public boolean saveAll(Map<String, Object> inputParams) throws BaseException;
	
}
