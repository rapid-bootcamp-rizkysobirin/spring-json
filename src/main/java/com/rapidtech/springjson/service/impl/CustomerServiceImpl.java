package com.rapidtech.springjson.service.impl;

import com.rapidtech.springjson.model.CustomerRequest;
import com.rapidtech.springjson.repository.CustomerRepo;
import com.rapidtech.springjson.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo repo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo repo){
        this.repo = repo;
    }

    @Override
    public Optional<CustomerRequest> saveCustomer(CustomerRequest requestModel) {
        if(requestModel == null){
            return Optional.empty();
        }
        return Optional.empty();
    }
}
