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
import com.hacorp.authen.repository.dao.UserDao;
import com.hacorp.authen.repository.entity.User;
import com.hacorp.authen.repository.model.UserInfo;
import com.hacorp.authen.repository.service.UserRepositoryService;


@Service("userRepositoryService")
public class UserRepositoryServiceImpl extends AbstractServiceClass implements UserRepositoryService {

	private UserDao entityObject;
	
	@Autowired
	public UserRepositoryServiceImpl(UserDao entityObject) {
		super();
		this.entityObject = entityObject;
	}
	
	@Override
	public User getUserByUsername(Map<String, Object> inputParams) throws BaseException {
		String userName = (String) inputParams.get(APIConstants.USERNAME_KEY);
		return entityObject.findById(userName).orElse(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> getUserInforList(Map<String, Object> inputParams) throws BaseException {
		int pageNum = inputParams.get(APIConstants.START_PAGE_NUMBER_KEY) == null ?
				Integer.parseInt(getEnv().getProperty(APIConstants.START_PAGE_NUMBER_KEY)) : Integer.parseInt(inputParams.get(APIConstants.START_PAGE_NUMBER_KEY).toString());
		int pageSize = inputParams.get(APIConstants.NUMBER_KEY) == null ?
				Integer.parseInt(getEnv().getProperty(APIConstants.NUMBER_KEY)) : Integer.parseInt(inputParams.get(APIConstants.NUMBER_KEY).toString());	
		
		String sql = "select new com.hacorp.shop.core.model.UserInfo(u.userName,u.masterUserName,u.status,u.email,u.userRoles) "
					+ "from user u "
					+ "where :userName is null or u.userName = :userName "
					+ "and :status is null or u.status = :status ";
		Query query = entityManager.createQuery(sql);
		query.setParameter("userName", inputParams.get(APIConstants.USERNAME_KEY).toString());
		query.setParameter("status", inputParams.get(APIConstants.STATUS_KEY).toString());
		query.setFirstResult((pageNum -1)* pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	@Override
	public Long getUserInforCount(Map<String, Object> inputParams) throws BaseException {
		
		String sql = "select count(*) "
					+ "from user u "
					+ "where :userName is null or u.userName = :userName "
					+ "and :status is null or u.status = :status ";
		Query query = entityManager.createQuery(sql);
		query.setParameter("userName", inputParams.get(APIConstants.USERNAME_KEY).toString());
		query.setParameter("status", inputParams.get(APIConstants.STATUS_KEY).toString());
		Long rs = (Long) query.getSingleResult();
		return rs;
	}
	
	@Override
	public boolean save(Map<String, Object> inputParams) throws BaseException {
		try {
			User item = (User) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.save(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), User.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), User.class.getName()));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean saveAll(Map<String, Object> inputParams) throws BaseException {
		try {
			List<User> item =  (List<User>) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.saveAll(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), User.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_010"), User.class.getName()));
		}
	}

	@Override
	public boolean update(Map<String, Object> inputParams) throws BaseException {
		try {
			User item = (User) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.save(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), User.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), User.class.getName()));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateAll(Map<String, Object> inputParams) throws BaseException {
		try {
			List<User> item =  (List<User>) inputParams.get(APIConstants.DOCUMENT_KEY);
			if(item != null) {
				entityObject.saveAll(item);
				return true;
			}else {
				throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), User.class.getName()));
			}
		} catch (Exception e) {
			logger.info(CommonUtil.getLogMessenge(e));
			throw new ServiceRuntimeException(String.format(getEnv().getProperty("MSG_011"), User.class.getName()));
		}
	}
	
	

}
