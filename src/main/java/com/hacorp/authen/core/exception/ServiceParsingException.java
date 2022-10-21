package com.hacorp.authen.core.exception;

public class ServiceParsingException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6891612682262201057L;

	/**
	 * 
	 */
	public ServiceParsingException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ServiceParsingException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceParsingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ServiceParsingException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ServiceParsingException(Throwable cause) {
		super(cause);
	}
	
	public ServiceParsingException(String message, String errorDescription) {
		super(message, errorDescription);
	}
	
}
