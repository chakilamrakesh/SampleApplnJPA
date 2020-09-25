package com.ojas.poc.message;

public class ResponseMessage {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public ResponseMessage() {
		// TODO Auto-generated constructor stub
	}

	
	public ResponseMessage(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + "]";
	}
	
}
