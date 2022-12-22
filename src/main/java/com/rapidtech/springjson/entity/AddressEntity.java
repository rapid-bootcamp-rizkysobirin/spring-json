package com.rapidtech.springjson.entity;

import com.rapidtech.springjson.model.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address_tab")
public class AddressEntity {
    @Id
    @TableGenerator(name = "address_id_generator", table = "sequence_tab",
                    pkColumnName = "gen_name", valueColumnName = "gen_value",
                    pkColumnValue = "address_id", initialValue = 0, allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "address_id_generator")
    private Long id;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "street", length = 100)
    private String address;
    @Column(name = "village", length = 100)
    private String village;
    @Column(name = "district", length = 100)
    private String district;
    @Column(name = "city", length = 100)
    private String city;
    @Column(name = "province", length = 100)
    private String province;

    @Column(name = "customer_id")
    private Long customerId;

    // address --> customer
    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;


    public AddressEntity(AddressModel model) {
        BeanUtils.copyProperties(model,this);
    }
}
