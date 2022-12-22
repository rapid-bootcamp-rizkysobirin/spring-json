package com.rapidtech.springjson.model;

import lombok.Data;

@Data
public class AddressModel {
    private String name;
    private String address;
    private String village;
    private String district;
    private String city;
    private String province;
}
