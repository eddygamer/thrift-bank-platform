package com.cybord.ti.thrift.error;

/**
 * @author eddyrs
 *
 */
public class ThriftBankServiceException extends Exception {

	private static final long serialVersionUID = -7900659635841387010L;

	private final transient ErrorMessage errorMessage;

	public ThriftBankServiceException(String message, String developerMessage, int httpStatus) {
		super(message);
		this.errorMessage = new ErrorMessage(message, developerMessage, httpStatus);
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

}
