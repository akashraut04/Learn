package com.example.demo.First.project.processor;

import com.example.demo.First.project.Services.EmployeeService;
import com.example.demo.First.project.bean.EmployeeBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmpProcessor implements Processor {

    @Autowired
    EmployeeService employeeService;


    @Override
    public void process(Exchange exchange) throws Exception {

        String strValue = (String) exchange.getIn().getBody();
        ObjectMapper objectMapper = new ObjectMapper();

        if (strValue.startsWith("{") || strValue.startsWith("[")) {

            EmployeeBean employeeBean = objectMapper.readValue(strValue, EmployeeBean.class);
            if (employeeBean.getOperation().equalsIgnoreCase("create")) {

                employeeService.addData(employeeBean);
            } else if (employeeBean.getOperation().equalsIgnoreCase("update")) {

                employeeService.addData(employeeBean);
            }
        }
    }
}
