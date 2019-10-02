package com.ug.crm.service;

import com.ug.crm.model.json.CustomerProfile;
import com.ug.crm.model.json.CustomerProfileResponseData;

public interface CrmService {

	CustomerProfileResponseData getCustomerProfile(String id);
	
	CustomerProfileResponseData createCustomerProfile(CustomerProfile customerProfile);
	
	CustomerProfileResponseData updateCustomerProfile(CustomerProfile customerProfile);
	
	void deleteCustomerProfile(String id);
}
