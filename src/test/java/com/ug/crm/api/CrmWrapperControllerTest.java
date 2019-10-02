package com.ug.crm.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import com.ug.crm.CrmWrapperServiceApplication;
import com.ug.crm.config.JwtTokenUtil;
import com.ug.crm.model.json.CustomerProfileResponseData;
import com.ug.crm.service.RestToSoapCrmServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrmWrapperServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CrmWrapperControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private JwtTokenUtil tokenUtil;
	
	@MockBean
	private RestToSoapCrmServiceImpl crmService;
	
	@Spy
	private CrmWrapperController controller;
	
	@Before
	private void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_given_valid_customer_id_and_valid_token_then_get_profile() throws RestClientException, MalformedURLException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer "+getToken());
		
		CustomerProfileResponseData testCustomer = new CustomerProfileResponseData();
		testCustomer.setId("1");
		Mockito.when(crmService.getCustomerProfile("1")).thenReturn(testCustomer);

		ResponseEntity<CustomerProfileResponseData> response = restTemplate.exchange(
				"http://localhost:" + port + "/api/v1/customers/profiles/1", HttpMethod.GET, new HttpEntity<>(headers),
				CustomerProfileResponseData.class);
		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals("1", response.getBody().getId());
	}
	
	@Test
	public void test_given_valid_customer_id_and_invalid_token_then_get_401() throws RestClientException, MalformedURLException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer "+ "xxxxx");
		
		CustomerProfileResponseData testCustomer = new CustomerProfileResponseData();
		testCustomer.setId("1");
		Mockito.when(crmService.getCustomerProfile("1")).thenReturn(testCustomer);

		ResponseEntity<CustomerProfileResponseData> response = restTemplate.exchange(
				"http://localhost:" + port + "/api/v1/customers/profiles/1", HttpMethod.GET, new HttpEntity<>(headers),
				CustomerProfileResponseData.class);
		assertNotNull(response);
		assertEquals(401, response.getStatusCodeValue());
	}
	
	private String getToken() {
		return tokenUtil.buildToken(new HashedMap(), "Test User");
	}

}
