/**
 * 
 */
package com.hacorp.authen.core.common;

import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public abstract class AbstractBasicCommonClass{

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	private Environment env;
	
	@Autowired
	protected HttpServletRequest httpServletRequest;

	@Autowired
	protected HttpServletResponse httpServletResponse;
	
//	@Autowired
//	protected JwtTokenUtils jwtTokenUtils;
	
	public Environment getEnv() {
		return env;
	}

	@Autowired
	public void setEnv(Environment env) {
		this.env = env;
	}
}
