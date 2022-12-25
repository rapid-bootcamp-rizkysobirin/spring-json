package com.rapidtech.springjson.service.impl;

import com.rapidtech.springjson.entity.CustomerEntity;
import com.rapidtech.springjson.model.CustomerModel;
import com.rapidtech.springjson.model.CustomerRequest;
import com.rapidtech.springjson.model.CustomerResponse;
import com.rapidtech.springjson.repository.CustomerRepo;
import com.rapidtech.springjson.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo repo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo repo){
        this.repo = repo;
    }

    @Override
    public Optional<CustomerModel> saveCustomer(CustomerModel requestModel) {
        if(requestModel == null){
            log.error("salah");
            return Optional.empty();
        }
//        return Optional.empty();
//            if(requestModel == null) {
//                return Optional.empty();
//            }
        CustomerEntity entity = new CustomerEntity(requestModel);

        try {
            this.repo.save(entity);
            return Optional.of(new CustomerModel(entity));
        }catch (Exception e){
            log.error("Customer save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }


    @Override
    public CustomerResponse saveAll(CustomerRequest requestModel){
        if(requestModel.getCustomers().isEmpty()){
            return new CustomerResponse();
        }
        CustomerResponse response = new CustomerResponse();
        int countSuccess = 0;
        int countFailed = 0;
        List<CustomerModel> customerModels = new ArrayList<>();
        for (CustomerModel model: requestModel.getCustomers()){
            // panggil method save
            Optional<CustomerModel> customerModel = this.saveCustomer(model);

            // check datanya
            if(customerModel.isPresent()){
                customerModels.add(model);
                countSuccess++;
            }else {
                countFailed++;
            }
        }
        //ini cara lain
        // return  new CustomerResponse(customerModels, countSuccess, countFailed);

        response.setData( customerModels);
        response.setSuccessSave(countSuccess);
        response.setFailedSave(countFailed);
        return response;

    }

    @Override
    public List<CustomerModel> getAll() {
        return null;
    }

    @Override
    public Optional<CustomerModel> getById(Long Id) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerModel> update(Long Id, CustomerModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerModel> delete(Long id) {
        return Optional.empty();
    }

}
