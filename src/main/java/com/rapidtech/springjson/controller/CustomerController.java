package com.rapidtech.springjson.controller;

import com.rapidtech.springjson.model.CustomerRequest;
import com.rapidtech.springjson.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService service;
    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Object> saveCustomer(@RequestBody CustomerRequest request){

        return ResponseEntity.ok().body(
                service.saveAll(request)
        );

    }
}
