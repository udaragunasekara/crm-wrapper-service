package com.ug.crm.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ug.crm.model.CustomerProfile;
import com.ug.crm.model.CustomerProfileResponseData;
import com.ug.crm.service.LegacyCrmClient;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

@RestController
@RequestMapping("/api/v1/clients")
public class CrmWrapperController {
	
	@Autowired
	private LegacyCrmClient wrapperService;

	@ApiOperation(value = "Returns a customer profile by ID", nickname = "customersProfilesIdGet", notes = "Returns the customer's profile data identified by the customer id", response = CustomerProfile.class, authorizations = {
			@Authorization(value = "oAuth2AuthCode", scopes = {
					@AuthorizationScope(scope = "", description = "") }) }, tags = { "customers", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "a customer profile to be returned", response = CustomerProfile.class),
			@ApiResponse(code = 403, message = "Not authorized to perform the action"),
			@ApiResponse(code = 404, message = "Requested resource not found"),
			@ApiResponse(code = 503, message = "Service unavailable") })
	@RequestMapping(value = "/customers/profiles/{id}", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<CustomerProfile> getCustomerProfile(
			@ApiParam(value = "ID of the customer to get", required = true) @PathVariable("id") String id) {
		return wrapperService.getCustomerProfile(id);
	}

	@ApiOperation(value = "Creates a Customer profile", nickname = "customersProfilesPost", notes = "Creates the customer's profile from the data posted in the body.", response = CustomerProfile.class, authorizations = {
			@Authorization(value = "oAuth2AuthCode", scopes = {
					@AuthorizationScope(scope = "", description = "") }) }, tags = { "customers", })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "a customer profile to be returned", response = CustomerProfile.class),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Not authorized to perform the action"),
			@ApiResponse(code = 503, message = "Service unavailable") })
	@RequestMapping(value = "/customers/profiles", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<CustomerProfile> createCustomerProfile(
			@ApiParam(value = "A JSON object containing customer profile information", required = true) @Valid @RequestBody CustomerProfile body) {
		return wrapperService.createCustomerProfile(body);
	}

	@ApiOperation(value = "Updates a Customer profile", nickname = "customersProfilesIdPut", notes = "Updates the customer's profile from the data posted in the body.", response = CustomerProfileResponseData.class, authorizations = {
			@Authorization(value = "oAuth2AuthCode", scopes = {
					@AuthorizationScope(scope = "", description = "") }) }, tags = { "customers", })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "updated customer profile to be returned", response = CustomerProfileResponseData.class),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Not authorized to perform the action"),
			@ApiResponse(code = 404, message = "Requested resource not found"),
			@ApiResponse(code = 503, message = "Service unavailable") })
	@RequestMapping(value = "/customers/profiles/{id}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	ResponseEntity<CustomerProfileResponseData> updateCustomerProfile(
			@ApiParam(value = "A JSON object containing customer profile information", required = true) @Valid @RequestBody CustomerProfile body,
			@ApiParam(value = "ID of the customer to update", required = true) @PathVariable("id") String id) {
		return wrapperService.updateCustomerProfile(body, id);
	}

	@ApiOperation(value = "Deletes the customer profile", nickname = "customersProfilesIdDelete", notes = "Deletes the customer profile idenfied by the id.", authorizations = {
			@Authorization(value = "oAuth2AuthCode", scopes = {
					@AuthorizationScope(scope = "", description = "") }) }, tags = { "customers", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 503, message = "Service unavailable") })
	@RequestMapping(value = "/customers/profiles/{id}", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteCustomerProfile(
			@ApiParam(value = "ID of the customer to delete", required = true) @PathVariable("id") String id) {
		return wrapperService.deleteCustomerProfile(id);
	}
}
