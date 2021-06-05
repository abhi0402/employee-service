package com.bootcamp.repository;

import com.bootcamp.model.EmployeeSkill;
import com.bootcamp.model.EmployeeSkillPrimaryKey;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeSkillRepository extends ReactiveCassandraRepository<EmployeeSkill, EmployeeSkillPrimaryKey> {
    @AllowFiltering
    Flux<EmployeeSkill> findByKeyJavaExpGreaterThanEqual(double i);
    @AllowFiltering
    Flux<EmployeeSkill> findByKeySpringExpGreaterThanEqual(double i);
    @AllowFiltering
    Flux<EmployeeSkill> findByKeySpringExpGreaterThanEqualAndKeyJavaExpGreaterThanEqual(double i, double j);
}
