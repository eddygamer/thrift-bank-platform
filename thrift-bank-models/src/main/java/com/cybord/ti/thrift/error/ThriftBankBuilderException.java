/**
 * 
 */
package com.cybord.ti.thrift.error;

/**
 * @author eddyrs
 *
 */
public class ThriftBankBuilderException  extends Exception{

	private static final long serialVersionUID = -8907335096197149928L;
	private String developerMessage;
		
	public ThriftBankBuilderException(String message) {
		super(message);
	}
	
	public ThriftBankBuilderException(String message,String devMessage) {
		super(message);
		this.developerMessage = devMessage;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}
