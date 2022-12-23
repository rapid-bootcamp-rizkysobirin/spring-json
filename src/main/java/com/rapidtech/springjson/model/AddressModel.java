package com.rapidtech.springjson.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class AddressModel {
    private Long id;
    private String name;
    private String  address;
    private String village;
    private String district;
    private String city;
    private String province;

}
