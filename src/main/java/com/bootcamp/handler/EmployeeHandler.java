package com.bootcamp.handler;

import com.bootcamp.dto.CommonResponseDto;
import com.bootcamp.dto.EmployeeDto;
import com.bootcamp.dto.EmpBySkillDto;
import com.bootcamp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Optional;

@Component
@Slf4j
public class EmployeeHandler {

    @Autowired
    private EmployeeService employeeService;

    public Mono<ServerResponse> createEmployee(ServerRequest request) {
        Mono<EmployeeDto> employeeDtoMono = request.bodyToMono(EmployeeDto.class);
        Mono<EmployeeDto> employeeDtoMonoResponse = employeeService.createEmployee(employeeDtoMono);
        return employeeDtoMonoResponse.flatMap(res -> {
            if (res.getStatus().equalsIgnoreCase("Created"))
                return ServerResponse.created(URI.create("/createEmployee/" + res.getId())).bodyValue(res);
            else
                return ServerResponse.badRequest().bodyValue(res);
        });
    }

    public Mono<ServerResponse> getEmployeesBySkillSet(ServerRequest request) {
        log.trace("getEmployeesBySkillSet invoked");
        Optional<String> javaExp = request.queryParam("java_exp");
        Optional<String> springExp = request.queryParam("spring_exp");
        Flux<EmpBySkillDto> empBySkillFlux = Flux.empty();
        if (!javaExp.isPresent() && !springExp.isPresent())
            return ServerResponse.badRequest().bodyValue(new CommonResponseDto("No query param provided in the request"));
        if (javaExp.isPresent() && springExp.isPresent())
            empBySkillFlux = employeeService.getEmpByJavaExpAndSpringExp(Double.parseDouble(springExp.get()), Double.parseDouble(javaExp.get()));
        if (javaExp.isPresent() && !springExp.isPresent())
            empBySkillFlux = employeeService.getEmpByJavaExp(Double.parseDouble(javaExp.get()));
        if (!javaExp.isPresent() && springExp.isPresent())
            empBySkillFlux = employeeService.getEmpBySpringExp(Double.parseDouble(springExp.get()));
        return ServerResponse.ok().body(empBySkillFlux, EmpBySkillDto.class);
    }

}
