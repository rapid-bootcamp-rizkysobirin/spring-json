package com.rapidtech.springjson.service;

import com.rapidtech.springjson.model.CustomerRequest;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerRequest> saveCustomer(CustomerRequest requestModel);
}
