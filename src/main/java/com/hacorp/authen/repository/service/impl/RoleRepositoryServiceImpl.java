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
import com.hacorp.authen.repository.dao.RoleDAO;
import com.hacorp.authen.repository.entity.Role;
import com.hacorp.authen.repository.service.RoleRepositoryService;


@Service("roleRepositoryService")
public class RoleRepositoryServiceImpl extends AbstractServiceClass implements RoleRepositoryService{

	@Autowired
	private RoleDAO entityObject;
	
//	@Autowired
//	public RoleRepositoryServiceImpl(RoleDAO entityObject) {
//		this.entityObject = entityObject;
//	}


	@Override
	public Role getRoleByRoleCode(Map<String, Object> inputParams) throws BaseException {
		
		String role = (String) inputParams.get(APIConstants.ROLE_KEY);
		return entityObject.findById(role).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getListRoleByRoleCode(Map<String, Object> inputParams) throws BaseException {
		
		List<String> roles =  (List<String>) inputParams.get(APIConstants.ROLE_KEY);
		String sql = "select * from role "
				+ "where role_code in :roleCode "
				+ "and ledger_status = :ledgerStatus";
		Query query = entityManager.createNativeQuery(sql, Role.class);
		query.setParameter("roleCode", roles);
		query.setParameter("ledgerStatus", APIConstants.LEDGER_STATUS_NORM);
		return query.getResultList();
	}

	@Override
	public boolean save(Map<String, Object> inputParams) throws BaseException {
		try {
			Role item = (Role) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.save(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), Role.class.getName()));
			}
			
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), Role.class.getName()));
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean saveAll(Map<String, Object> inputParams) throws BaseException {
		try {
			List<Role> item =  (List<Role>) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.saveAll(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), Role.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), Role.class.getName()));
		}
	}

	@Override
	public boolean update(Map<String, Object> inputParams) throws BaseException {
		try {
			Role item = (Role) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.save(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), Role.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), Role.class.getName()));
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean updateAll(Map<String, Object> inputParams) throws BaseException {
		try {
			List<Role> item =  (List<Role>) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.saveAll(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), Role.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), Role.class.getName()));
		}
	}

	@Override
	public boolean delete(Map<String, Object> inputParams) throws BaseException {
		try {
			Role item = (Role) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.delete(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_012"), Role.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_012"), Role.class.getName()));
		}
	}

	
}
