package com.cybord.ti.thrift.client;

import java.util.List;

import com.cybord.ti.thrift.client.error.ThriftBankClientException;
import com.cybord.ti.thrift.dto.RoleDto;

/**
 * @author eddyrs
 *
 */
public interface ThriftBankClient {

	/**
	 * Get the full list of Roles
	 * 
	 * @return List<RoleDto>
	 * @throws ThriftBankClientException
	 */
	public List<RoleDto> getAllRoles() throws ThriftBankClientException;

	/**
	 * Get the full list of Roles
	 * 
	 * @return RoleDto
	 * @throws ThriftBankClientException
	 */
	public RoleDto getRoleByName(String name) throws ThriftBankClientException;

	/**
	 * Update role
	 * 
	 * @return RoleDto
	 * @throws ThriftBankClientException
	 */
	public RoleDto updateRole(RoleDto roleDto) throws ThriftBankClientException;

	/**
	 * Create rule
	 * 
	 * @return RoleDto
	 * @throws ThriftBankClientException
	 */
	public RoleDto createRule(RoleDto ruleDto) throws ThriftBankClientException;
}
