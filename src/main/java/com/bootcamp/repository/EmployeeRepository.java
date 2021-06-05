package com.bootcamp.repository;

import com.bootcamp.model.Employee;
import com.bootcamp.model.EmployeePrimaryKey;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveCassandraRepository<Employee, EmployeePrimaryKey> {
    Mono<Employee> findOneByKeyId(int i);
}
