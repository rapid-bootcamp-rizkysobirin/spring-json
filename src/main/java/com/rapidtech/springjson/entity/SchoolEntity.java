package com.rapidtech.springjson.entity;

import com.rapidtech.springjson.model.SchoolModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "school_tab")
public class SchoolEntity {
    @Id
    @TableGenerator(name="school_id_generator", table="sequence_tab",
                    pkColumnName = "gen_name", valueColumnName = "gen_value",
                    pkColumnValue = "school_id",initialValue = 0 , allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "school_id_generator")
    private Long id;
    @Column(name = "title", length = 20, nullable = false)
    private String title;
    @Column(name = "name", length = 200, nullable = false)
    private String name;
    @Column(name = "level", length= 10, nullable = false)
    private String level;

    @Column(name = "customer_id")
    private Long customerId;

    // school --> customer
    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    public SchoolEntity(SchoolModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
