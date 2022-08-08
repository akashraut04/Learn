package com.example.demo.First.project.route;

import com.example.demo.First.project.processor.EmpProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRoute extends RouteBuilder {


    @Autowired
    EmpProcessor empProcessor;
    @Override
    public void configure() throws Exception {

        from("activemq:test")
                .process(empProcessor)
//                .choice()
                .log("send massage")
                .to("activemq:EmployeeQueue")
                .end();

    }
}
