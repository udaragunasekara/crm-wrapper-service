package com.ug.crm.service.feign;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ug.crm.model.soap.CustomerType;

@FeignClient(value = "crm",url = "${feign.legacy.crm.url}", configuration = FeignSoapClientConfiguration.class)
public interface LegacyCrmFeignClient {

	@RequestMapping(value = "/customers/profiles/{id}", produces = MediaType.TEXT_XML_VALUE, consumes = MediaType.TEXT_XML_VALUE, method = RequestMethod.GET)
	CustomerType getCustomerProfile(@PathVariable("id") String id);

	@RequestMapping(value = "/customers/profiles", produces = MediaType.TEXT_XML_VALUE, consumes = MediaType.TEXT_XML_VALUE, method = RequestMethod.POST)
	CustomerType createCustomerProfile(@Valid @RequestBody CustomerType body);

	@RequestMapping(value = "/customers/profiles/{id}", produces = MediaType.TEXT_XML_VALUE, consumes = MediaType.TEXT_XML_VALUE, method = RequestMethod.PUT)
	CustomerType updateCustomerProfile(@Valid @RequestBody CustomerType body,
			@PathVariable("id") String id);

	@RequestMapping(value = "/customers/profiles/{id}", method = RequestMethod.DELETE)
	void deleteCustomerProfile(@PathVariable("id") String id);

}
