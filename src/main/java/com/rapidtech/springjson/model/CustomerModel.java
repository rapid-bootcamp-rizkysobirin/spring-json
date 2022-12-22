package com.rapidtech.springjson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CustomerModel {
    private Long id;
    private String fullName;
    private List<AddressModel> address;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String placeOfBirth;
    private List<SchoolModel> schools;
}
