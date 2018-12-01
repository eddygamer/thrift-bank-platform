package com.cybord.ti.thrift.client.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cybord.ti.thrift.client.ThriftBankClient;
import com.cybord.ti.thrift.client.ThriftBankClientImpl;
import com.cybord.ti.thrift.client.error.ThriftBankClientException;
import com.cybord.ti.thrift.client.mock.ThriftBankRestClientWiredMock;
import com.cybord.ti.thrift.client.util.WiredMockConstants;
import com.cybord.ti.thrift.dto.RoleDto;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

/**
 * @author eddyrs
 *
 */
public class RoleClientTest {

	private ThriftBankClient client;
	private static WireMockServer wireMockServer;

	@Before
	public void setUp() throws Exception {
		wireMockServer = new WireMockServer(WiredMockConstants.APPLICATION_PORT);
		client = new ThriftBankClientImpl(WiredMockConstants.THRIFT_URL, WiredMockConstants.THRIFT_CONTEXT, 2, 2,
				TimeUnit.SECONDS);
		WireMock.configureFor(WiredMockConstants.THRIFT_URL.concat(WiredMockConstants.THRIFT_CONTEXT),
				WiredMockConstants.APPLICATION_PORT);
		wireMockServer.start();
	}

	@After
	public void end() {
		wireMockServer.stop();
	}

	@Test
	public void getAllRoles() throws ThriftBankClientException {
		ThriftBankRestClientWiredMock.getAllRoles(wireMockServer);
		List<RoleDto> roles = client.getAllRoles();
		assertNotNull(roles);
		assertTrue(!roles.isEmpty());
	}
	
	@Test
	public void getRoleByName() throws ThriftBankClientException {
		ThriftBankRestClientWiredMock.getRoleByName(wireMockServer, WiredMockConstants.ROLE_NAME_CORRECT);
		RoleDto role = client.getRoleByName(WiredMockConstants.ROLE_NAME_CORRECT);
		assertNotNull(role);
		assertEquals(WiredMockConstants.ROLE_NAME_CORRECT, role.getName());
	}
	
}
