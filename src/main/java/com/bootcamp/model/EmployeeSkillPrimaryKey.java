package com.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSkillPrimaryKey {

    @PrimaryKeyColumn(name = "emp_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int id;
    @PrimaryKeyColumn(name = "java_exp", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private double javaExp;
    @PrimaryKeyColumn(name = "spring_exp", ordinal = 2, type = PrimaryKeyType.PARTITIONED)
    private double springExp;

}
