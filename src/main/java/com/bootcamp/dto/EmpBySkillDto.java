package com.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpBySkillDto {

    @JsonProperty("emp_id")
    private int id;
    @JsonProperty("emp_name")
    private String name;
    @JsonProperty("emp_city")
    private String city;
    @JsonProperty("emp_phone")
    private String phone;
    @JsonProperty("java_exp")
    private double javaExp;
    @JsonProperty("spring_exp")
    private double springExp;

}
