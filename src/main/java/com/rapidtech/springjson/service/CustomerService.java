package com.rapidtech.springjson.service;

import com.rapidtech.springjson.model.CustomerModel;
import com.rapidtech.springjson.model.CustomerRequest;
import com.rapidtech.springjson.model.CustomerResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<CustomerModel> saveCustomer(CustomerModel requestModel);

    CustomerResponse saveAll(CustomerRequest requestModel);
    List<CustomerModel> getAll();
    Optional<CustomerModel> getById(Long Id);
    Optional<CustomerModel> update(Long Id,CustomerModel model);
    Optional<CustomerModel> delete(Long id);
}
