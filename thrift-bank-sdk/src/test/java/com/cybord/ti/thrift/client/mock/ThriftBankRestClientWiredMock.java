package com.cybord.ti.thrift.client.mock;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.cybord.ti.thrift.client.endpoints.ThriftBankEndpoints;
import com.cybord.ti.thrift.client.error.ThriftBankClientException;
import com.cybord.ti.thrift.client.util.WebTargetMock;
import com.cybord.ti.thrift.client.util.WiredMockConstants;
import com.cybord.ti.thrift.dto.RoleDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;

import wiremock.org.apache.http.HttpStatus;

/**
 * @author eddyrs
 *
 */
public class ThriftBankRestClientWiredMock {

	public static void getAllRoles(WireMockServer wireMockServer) throws ThriftBankClientException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<RoleDto> roles = mapper.readValue(new File(WiredMockConstants.ROLES),
					new TypeReference<List<RoleDto>>() {
					});
			String output = mapper.writeValueAsString(roles);
			String endpoint = WiredMockConstants.THRIFT_CONTEXT.concat(ThriftBankEndpoints.roleEndpoint());
			WebTargetMock.getRequest(wireMockServer, output, endpoint, HttpStatus.SC_OK);
		} catch (IOException e) {
			throw new ThriftBankClientException("Error in getAllRoles wired mocks " + e.getMessage(),
					HttpStatus.SC_CONFLICT);
		}
	}
	
	public static void getRoleByName(WireMockServer wireMockServer,String name) throws ThriftBankClientException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			RoleDto roles = mapper.readValue(new File(WiredMockConstants.ROLE),
					new TypeReference<RoleDto>() {
					});
			String output = mapper.writeValueAsString(roles);
			String endpoint = WiredMockConstants.THRIFT_CONTEXT.concat(ThriftBankEndpoints.roleByName(name));
			WebTargetMock.getRequest(wireMockServer, output, endpoint, HttpStatus.SC_OK);
		} catch (IOException e) {
			throw new ThriftBankClientException("Error in getAllRoles wired mocks " + e.getMessage(),
					HttpStatus.SC_CONFLICT);
		}
	}

}
