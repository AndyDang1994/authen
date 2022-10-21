/**
 * 
 */
package com.hacorp.authen.core.common;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractServiceClass extends AbstractRepositoryClass{

	private ProcessManagerService processManagerService;

	public ProcessManagerService getProcessManagerService() {
		return processManagerService;
	}

	@Autowired
	public void setProcessManagerService(ProcessManagerService processManagerService) {
		this.processManagerService = processManagerService;
	}
	
	
	
}







