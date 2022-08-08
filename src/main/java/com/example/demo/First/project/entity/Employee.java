package com.example.demo.First.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="employee_Id")
private int employeeId;
@Column(name="employee_Name")
private String employeeName;
@Column(name="company_Id")
private int companyId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id", nullable=false,insertable = false ,updatable = false)
    @JsonBackReference
    Company company;


}
