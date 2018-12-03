package com.cybord.ti.thrift.client.util;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.github.tomakehurst.wiremock.WireMockServer;

/**
 * @author eddyxs
 *
 */
public class WebTargetMock {

	public static void getRequest(WireMockServer wireMockServer, String output, String endpoint,int httpStatus) {
		wireMockServer.stubFor(get(urlEqualTo(endpoint)).willReturn(aResponse().withStatus(httpStatus)
				.withHeader(WiredMockConstants.APPLICATION_CONTENT, WiredMockConstants.APPLICATION_JSON)
				.withBody(output)));
	}
	
	public static void postRequest(WireMockServer wireMockServer, String input, String output, String endpoint,int httpStatus) {
		wireMockServer.stubFor(post(urlEqualTo(endpoint)).withRequestBody(equalToJson(input))
				.willReturn(aResponse().withStatus(httpStatus)
						.withHeader(WiredMockConstants.APPLICATION_CONTENT, WiredMockConstants.APPLICATION_JSON)
						.withBody(output)));
	}
	
	public static void putRequest(WireMockServer wireMockServer, String input, String output, String endpoint,int httpStatus) {
		wireMockServer.stubFor(put(urlEqualTo(endpoint)).withRequestBody(equalToJson(input))
				.willReturn(aResponse().withStatus(httpStatus)
						.withHeader(WiredMockConstants.APPLICATION_CONTENT, WiredMockConstants.APPLICATION_JSON)
						.withBody(output)));
	}
}
