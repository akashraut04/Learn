package com.example.demo.First.project.route;

import com.example.demo.First.project.processor.CompProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class CompanyRoute extends RouteBuilder {

    @Autowired
    CompProcessor compProcessor;
    @Override
    public void configure() throws Exception {

        from("activemq:test")
                .process(compProcessor)
//                .choice()
                .log("send massage")
                .to("activemq:CompanyQueue")
                .end();
    }
}
