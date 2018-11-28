package com.cybord.ti.thrift.error;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author eddyrs
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
	private String developerMessage;
	private int httpStatus;
	private String message;

	public ErrorMessage() {
	}

	public ErrorMessage(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public ErrorMessage(String message, int httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	public ErrorMessage(String message,String developerMessage, int httpStatus) {
		this.message = message;
		this.developerMessage = developerMessage;
		this.httpStatus = httpStatus;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	@Override
	public String toString() {
		return "ErrorMessage [developerMessage=" + developerMessage + ", httpStatus=" + httpStatus + ", message="
				+ message + "]";
	}

}
