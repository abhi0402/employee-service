package com.bootcamp.router;

import com.bootcamp.handler.EmployeeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class EmployeeRouter {

    @Autowired
    private EmployeeHandler employeeHandler;

    @Bean
    public RouterFunction<ServerResponse> employeeRoute() {
        return RouterFunctions.route()
                .POST("/createEmployee", accept(MediaType.APPLICATION_JSON), employeeHandler::createEmployee)
                .GET("/findEmpSkillset", employeeHandler::getEmployeesBySkillSet)
                .build();
    }

}
