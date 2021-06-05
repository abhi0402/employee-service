package com.bootcamp.util;

import com.bootcamp.dto.EmpBySkillDto;
import com.bootcamp.dto.EmployeeDto;
import com.bootcamp.model.Employee;
import com.bootcamp.model.EmployeePrimaryKey;
import com.bootcamp.model.EmployeeSkill;
import com.bootcamp.model.EmployeeSkillPrimaryKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Mapper {

    public static Employee mapDtoToEmpEntity(EmployeeDto empDto) {
        Employee employee = new Employee();
        employee.setKey(new EmployeePrimaryKey(empDto.getId()));
        employee.setName(empDto.getName());
        employee.setCity(empDto.getCity());
        employee.setPhone(empDto.getPhone());
        return employee;
    }

    public static EmployeeSkill mapDtoToEmpSkillEntity(EmployeeDto empDto) {
        EmployeeSkill empSkill = new EmployeeSkill();
        empSkill.setKey(new EmployeeSkillPrimaryKey(empDto.getId(), empDto.getJavaExp(), empDto.getSpringExp()));
        return empSkill;
    }

    public static EmpBySkillDto mapEmpAndEmpSkillToDto(Employee emp, EmployeeSkill empSkill) {
        EmpBySkillDto empDto = new EmpBySkillDto();
        empDto.setId(emp.getKey().getId());
        empDto.setName(emp.getName());
        empDto.setCity(emp.getCity());
        empDto.setPhone(emp.getPhone());
        empDto.setJavaExp(empSkill.getKey().getJavaExp());
        empDto.setSpringExp(empSkill.getKey().getSpringExp());
        return empDto;
    }

    public static String mapEmpToString(EmployeeDto emp) {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result = mapper.writeValueAsString(emp);
            ObjectNode obj = (ObjectNode) mapper.readTree(result);
            obj.remove("status");
            result = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
