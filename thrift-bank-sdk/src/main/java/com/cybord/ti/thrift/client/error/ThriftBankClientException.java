package com.cybord.ti.thrift.client.error;

import com.cybord.ti.thrift.error.ErrorMessage;

/**
 * @author hha0009
 *
 */
public class ThriftBankClientException extends Exception {

	private final transient ErrorMessage errorMessage;

	private static final long serialVersionUID = -7900659635841387010L;

	public ThriftBankClientException(String message, int httpStatus) {
		super(message);
		errorMessage = new ErrorMessage(message, httpStatus);
	}

	public ThriftBankClientException(String message,ErrorMessage errorMessage) {
		super(message);
		this.errorMessage = errorMessage;
	}

	public ThriftBankClientException(String message, String developerMessage, int httpStatus) {
		super(message);
		errorMessage = new ErrorMessage(message,developerMessage, httpStatus);
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
}
