/**
 * 
 */
package com.hacorp.authen.core.exception;

import javax.servlet.ServletException;

public class UnauthorizedException extends ServletException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UnauthorizedException() {
		super();
	}

	
	/**
	 * @param message
	 * @param cause
	 */
	public UnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UnauthorizedException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UnauthorizedException(Throwable cause) {
		super(cause);
	}

}
