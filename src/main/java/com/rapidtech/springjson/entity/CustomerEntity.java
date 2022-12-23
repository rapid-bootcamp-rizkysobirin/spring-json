package com.rapidtech.springjson.entity;

import com.rapidtech.springjson.model.AddressModel;
import com.rapidtech.springjson.model.CustomerModel;
import com.rapidtech.springjson.model.SchoolModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_tab")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "customer_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="customer_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_id_generator")
    private Long id;
    @Column(name = "customer_name", length = 100,nullable = false)
    private String fullName;
    @Column(name = "gender", length = 10,nullable = false)
    private String gender;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name ="date_of_birth")
    private Date dateOfBirth;
    @Column(name = "place_of_birth")
    private String placeOfBirth;


    //customer --> address
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> address;

    //customer-->school
    @OneToMany(mappedBy = "customer",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SchoolEntity> schools = new ArrayList<>();

//    public CustomerEntity(CustomerModel customer){
//        this.fullName = customer.getFullName();
//        this.dateOfBirth = customer.getDateOfBirth();
//        this.gender = customer.getGender();
//        for (AddressModel address : customer.getAddress()){
//            this.address.add(new AddressEntity(address));
//        }
//        for (SchoolModel school : customer.getSchools()){
//            this.schools.add(new SchoolEntity(school));
//        }
//    }
    public CustomerEntity(CustomerModel model) {
    BeanUtils.copyProperties(model,this);
}

}
