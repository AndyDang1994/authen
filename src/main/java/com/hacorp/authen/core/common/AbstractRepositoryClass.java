package com.hacorp.authen.core.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hacorp.authen.configuration.MysqlNamedQueries;


public abstract class AbstractRepositoryClass extends AbstractBasicCommonClass{
	protected final Logger logger = LoggerFactory.getLogger(getClass());


	@PersistenceContext(unitName = "entityManager")
	protected EntityManager entityManager;

	private MysqlNamedQueries mysqlNamedQueries;
	
	private RepositoryManagerService repositoryManagerService;


	public MysqlNamedQueries getMysqlNamedQueries() {
		return mysqlNamedQueries;
	}
	
	@Autowired
	public void setMysqlNamedQueries(MysqlNamedQueries mysqlNamedQueries) {
		this.mysqlNamedQueries = mysqlNamedQueries;
	}

	public RepositoryManagerService getRepositoryManagerService() {
		return repositoryManagerService;
	}

	@Autowired
	public void setRepositoryManagerService(RepositoryManagerService repositoryManagerService) {
		this.repositoryManagerService = repositoryManagerService;
	}
	
	
	
}
