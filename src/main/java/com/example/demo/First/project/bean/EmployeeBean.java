package com.example.demo.First.project.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBean {

    private Integer employeeId;
    private String employeeName;
    private int companyId;
    private String operation;

}
