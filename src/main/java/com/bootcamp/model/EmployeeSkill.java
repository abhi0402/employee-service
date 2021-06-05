package com.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("emp_skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSkill {

    @PrimaryKey
    private EmployeeSkillPrimaryKey key;

}
