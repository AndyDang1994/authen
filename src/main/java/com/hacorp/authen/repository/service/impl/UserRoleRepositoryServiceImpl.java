package com.hacorp.authen.repository.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacorp.authen.core.common.AbstractServiceClass;
import com.hacorp.authen.core.constant.APIConstants;
import com.hacorp.authen.core.exception.BaseException;
import com.hacorp.authen.core.exception.ServiceRuntimeException;
import com.hacorp.authen.core.utils.CommonUtil;
import com.hacorp.authen.repository.dao.UserRolesDao;
import com.hacorp.authen.repository.entity.UserRole;
import com.hacorp.authen.repository.service.UserRoleRepositoryService;


@Service("userRoleRepositoryService")
public class UserRoleRepositoryServiceImpl extends AbstractServiceClass implements UserRoleRepositoryService {

	private UserRolesDao entityObject;
	
	
	@Autowired
	public UserRoleRepositoryServiceImpl(UserRolesDao entityObject) {
		this.entityObject = entityObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getUserRoleByUserName(Map<String, Object> inputParams) throws BaseException {
		try {
			String sql = "select u.* from user_role u "
					+ "where u.user_name = :userName "
					+ "and u.ledger_status = :ledgerStatus";
			Query query = entityManager.createNativeQuery(sql, UserRole.class);
			query.setParameter("userName", inputParams.get(APIConstants.USERNAME_KEY).toString());
			query.setParameter("ledgerStatus", inputParams.get(APIConstants.STATUS_KEY).toString());
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceRuntimeException(getEnv().getProperty("MSG_002"));
		}
		
	}

	@Override
	public boolean update(Map<String, Object> inputParams) throws BaseException {
		try {
			UserRole item = (UserRole) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.save(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), UserRole.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), UserRole.class.getName()));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateAll(Map<String, Object> inputParams) throws BaseException {
		try {
			List<UserRole> item = (List<UserRole>) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.saveAll(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), UserRole.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), UserRole.class.getName()));
		}
	}

	@Override
	public boolean save(Map<String, Object> inputParams) throws BaseException {
		try {
			UserRole item = (UserRole) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.save(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), UserRole.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), UserRole.class.getName()));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean saveAll(Map<String, Object> inputParams) throws BaseException {
		try {
			List<UserRole> item = (List<UserRole>) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.saveAll(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), UserRole.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), UserRole.class.getName()));
		}
	}

}
