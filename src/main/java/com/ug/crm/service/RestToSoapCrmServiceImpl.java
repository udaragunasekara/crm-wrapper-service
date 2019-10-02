package com.ug.crm.service;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ug.crm.exception.ProfileNotFoundException;
import com.ug.crm.model.json.CustomerProfile;
import com.ug.crm.model.json.CustomerProfileResponseData;
import com.ug.crm.model.soap.CustomerType;
import com.ug.crm.service.feign.LegacyCrmFeignClient;

/**
 * This Service implementation converts the rest api call to the legacy format
 * It uses a Feign client configured to handle SOAP to communicate with the legacy CRM system
 * which accepts only SOAP messages.
 * 
 * @author udaragunasekara
 *
 */
@Service
public class RestToSoapCrmServiceImpl implements CrmService {

	@Autowired
	private LegacyCrmFeignClient crmClient;

	@Override
	public CustomerProfileResponseData getCustomerProfile(String id) {
		CustomerType customerProfileType = crmClient.getCustomerProfile(id);
		if (customerProfileType == null) {
			throw new ProfileNotFoundException(String.format("Customer Profile with Id %s not found", id));
		}
		return toCustomerProfile(customerProfileType);
	}

	@Override
	public CustomerProfileResponseData createCustomerProfile(CustomerProfile customerProfile) {
		CustomerType customerType = fromCustomerProfile(customerProfile);
		return toCustomerProfile(crmClient.createCustomerProfile(customerType));
	}

	@Override
	public CustomerProfileResponseData updateCustomerProfile(CustomerProfile customerProfile) {
		throw new NotImplementedException("update operation is not yet implemented");
	}

	@Override
	public void deleteCustomerProfile(String id) {
		throw new NotImplementedException("delete operation is not yet implemented");

	}

	private CustomerProfileResponseData toCustomerProfile(CustomerType customerProfileType) {
		CustomerProfileResponseData profile = new CustomerProfileResponseData();
		profile.setId(customerProfileType.getCustomerID());
		profile.setFirstName(customerProfileType.getFirstName());
		profile.setLastName(customerProfileType.getLastName());

		// TODO - fill up the rest of the fields

		return profile;
	}
	
	private CustomerType fromCustomerProfile(CustomerProfile customerProfile) {
		CustomerType customerType = new CustomerType();
		customerType.setFirstName(customerProfile.getFirstName());
		customerType.setLastName(customerProfile.getLastName());
		
		return customerType;
	}

}
