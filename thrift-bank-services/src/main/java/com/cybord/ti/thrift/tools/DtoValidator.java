package com.cybord.ti.thrift.tools;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cybord.ti.thrift.dto.RoleDto;
import com.cybord.ti.thrift.error.ThriftBankServiceException;


/**
 * @author eddyrs
 *
 */
@Component
public class DtoValidator {
	
	public DtoValidator() {
	}

	public void createValidator(RoleDto o) throws ThriftBankServiceException{
		if (o.getName() == null||o.getCreatedAt() == null) {
			throw new ThriftBankServiceException("Field required",String.format("Name and CreatedAt are required."),
					HttpStatus.BAD_REQUEST.value());
		}
	}
	
	public void updateValidator(RoleDto o) throws ThriftBankServiceException{
		if (o.getName() == null) {
			throw new ThriftBankServiceException("Field required",String.format("Name is required."),
					HttpStatus.BAD_REQUEST.value());
		}
	}
	
}
