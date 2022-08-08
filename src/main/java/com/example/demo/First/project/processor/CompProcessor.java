package com.example.demo.First.project.processor;

import com.example.demo.First.project.Services.CompanyService;
import com.example.demo.First.project.bean.CompanyBean;
import com.example.demo.First.project.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component

public class CompProcessor implements Processor {

    @Autowired
    CompanyService companyService;

    @Override
    public void process(Exchange exchange) throws Exception {

       String strValue = (String) exchange.getIn().getBody();
        ObjectMapper objectMapper=new ObjectMapper();

        if (strValue.startsWith("{") || strValue.startsWith("[")) {

            CompanyBean companyBean=objectMapper.readValue(strValue,CompanyBean.class);
            if (companyBean.getOperation().equalsIgnoreCase("create")){

                companyService.addCompany(companyBean);
            }else if(companyBean.getOperation().equalsIgnoreCase("update")){
                companyService.addCompany(companyBean);
            }


        }

    }
}
