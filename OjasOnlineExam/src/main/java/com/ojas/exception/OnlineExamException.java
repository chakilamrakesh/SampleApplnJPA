package com.ojas.exception;

/**
 * 
 * @author kmahendra
 *
 */
public class OnlineExamException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OnlineExamException(){
		super();
	}

	public OnlineExamException(String message) {
		super(message);
	}

	public OnlineExamException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
