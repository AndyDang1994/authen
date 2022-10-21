/**
 * 
 */
package com.hacorp.authen.core.exception;

public abstract class BaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8770855000763401663L;

	protected String errorDescription;
	
	/**
	 * 
	 */
	public BaseException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BaseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @param message
	 * @param errorDescription
	 * @param cause
	 */
	public BaseException(String message, String errorDescription,Throwable cause) {
		super(message, cause);
		this.errorDescription = errorDescription;
	}
	
	/**
	 * @param message
	 */
	public BaseException(String message) {
		super(message);
	}
	
	/**
	 * @param message
	 */
	public BaseException(String message,String errorDescription) {
		super(message);
		this.errorDescription = errorDescription;
	}

	/**
	 * @param cause
	 */
	public BaseException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
}
