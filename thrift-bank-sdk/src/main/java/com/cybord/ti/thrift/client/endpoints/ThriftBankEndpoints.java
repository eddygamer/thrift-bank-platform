package com.cybord.ti.thrift.client.endpoints;

/**
 * @author eddyrs
 *
 */
public class ThriftBankEndpoints {

	private static final String ROLE = "/roles";

	public static String roleEndpoint() {
		return ROLE;
	}

	public static String roleByName(String name) {
		return ROLE.concat("/").concat(name);
	}
}
