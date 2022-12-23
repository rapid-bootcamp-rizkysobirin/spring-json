package com.rapidtech.springjson.service;

import com.rapidtech.springjson.model.CustomerModel;
import com.rapidtech.springjson.model.CustomerRequest;
import com.rapidtech.springjson.model.CustomerResponse;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerModel> saveCustomer(CustomerModel requestModel);

    CustomerResponse saveAll(CustomerRequest requestModel);
}
