package com.ug.crm.service;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ug.crm.model.CustomerProfile;
import com.ug.crm.model.CustomerProfileResponseData;

@FeignClient(url = "${feign.legacy.crm.url}")
public interface LegacyCrmClient {

	@RequestMapping(value = "/customers/profiles/{id}", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<CustomerProfile> getCustomerProfile(@PathVariable("id") String id);

	@RequestMapping(value = "/customers/profiles", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<CustomerProfile> createCustomerProfile(@Valid @RequestBody CustomerProfile body);

	@RequestMapping(value = "/customers/profiles/{id}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<CustomerProfileResponseData> updateCustomerProfile(@Valid @RequestBody CustomerProfile body,
			@PathVariable("id") String id);

	@RequestMapping(value = "/customers/profiles/{id}", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteCustomerProfile(@PathVariable("id") String id);

}
