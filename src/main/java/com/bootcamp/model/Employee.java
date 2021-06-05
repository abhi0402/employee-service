package com.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("emp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @PrimaryKey
    private EmployeePrimaryKey key;
    @Column("emp_name")
    private String name;
    @Column("emp_city")
    private String city;
    @Column("emp_phone")
    private String phone;

}
