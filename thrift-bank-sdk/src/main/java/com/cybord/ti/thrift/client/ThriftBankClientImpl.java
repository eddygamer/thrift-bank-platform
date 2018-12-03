package com.cybord.ti.thrift.client;

import java.io.StringReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cybord.ti.thrift.client.endpoints.ThriftBankEndpoints;
import com.cybord.ti.thrift.client.error.ThriftBankClientException;
import com.cybord.ti.thrift.dto.RoleDto;
import com.cybord.ti.thrift.error.ErrorMessage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author eddyrs
 *
 */
public class ThriftBankClientImpl extends AbstractClient implements ThriftBankClient {

	private static final Logger log = LoggerFactory.getLogger(ThriftBankClient.class);

	public ThriftBankClientImpl(String baseUrl) {
		super(baseUrl);
	}

	public ThriftBankClientImpl(String url, String contextPath) {
		super(url, contextPath);
	}

	public ThriftBankClientImpl(String baseUrl, int maxRetries, int delay, TimeUnit unit) {
		super(baseUrl, maxRetries, delay, unit);
	}

	public ThriftBankClientImpl(String url, String contextPath, int maxRetries, int delay, TimeUnit unit) {
		super(url, contextPath, maxRetries, delay, unit);
	}

	@Override
	public List<RoleDto> getAllRoles() throws ThriftBankClientException {
		log.info("Getting Roles list.");
		String endpoint = ThriftBankEndpoints.roleEndpoint();
		Response response = get(endpoint, MediaType.APPLICATION_JSON);
		return parseResponse(response, new TypeReference<List<RoleDto>>() {
		});
	}

	@Override
	public RoleDto getRoleByName(String name) throws ThriftBankClientException {
		log.info("Getting role by name {}.", name);
		String endpoint = ThriftBankEndpoints.roleByName(name);
		Response response = get(endpoint, MediaType.APPLICATION_JSON);
		return parseResponse(response, new TypeReference<RoleDto>() {
		});
	}

	@Override
	public RoleDto updateRole(RoleDto roleDto) throws ThriftBankClientException {
		log.info("Update role by name {}.", roleDto);
		String endpoint = ThriftBankEndpoints.roleEndpoint();
		Response response = put(endpoint, MediaType.APPLICATION_JSON, roleDto);
		return parseResponse(response, new TypeReference<RoleDto>() {
		});
	}

	@Override
	public RoleDto createRule(RoleDto roleDto) throws ThriftBankClientException {
		String endpoint = ThriftBankEndpoints.roleEndpoint();
		Response response = post(endpoint, MediaType.APPLICATION_JSON, roleDto);
		return parseResponse(response, new TypeReference<RoleDto>() {
		});
	}

	@Override
	protected <T> T parseResponse(Response response, TypeReference<T> entityType) throws ThriftBankClientException {
		T result;
		int status = response.getStatus();
		log.info(String.format("Status %s", status));
		String content = "";
		try {
			content = response.readEntity(String.class);
			ObjectMapper mapper = new ObjectMapper();
			if (response.getStatusInfo().getFamily() == Status.Family.SUCCESSFUL) {
				if (entityType != null) {
					result = mapper.readValue(new StringReader(content), entityType);
				} else {
					result = null;
				}

			} else {
				log.info(String.format("Error response: %s", content));
				if (content.contains("message") && content.contains("httpStatus")) {
					ErrorMessage error = mapper.readValue(new StringReader(content), new TypeReference<ErrorMessage>() {
					});
					throw new ThriftBankClientException(error.getMessage(), error.getDeveloperMessage(), status);
				} else {
					throw new ThriftBankClientException("Unexpected services response",
							String.format("Error response: %s", content), status);
				}
			}
		} catch (ThriftBankClientException e) {
			throw e;
		} catch (Exception e) {
			log.info(String.format("%s : %s", e.getClass(), e.getMessage()));
			throw new ThriftBankClientException("Unexpected services response : " + e.getMessage(), content,
					Status.EXPECTATION_FAILED.getStatusCode());
		}
		return result;
	}

}
