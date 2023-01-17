package com.example.demo.First.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="employee_id")
private Integer employeeId;
@Column(name="employee_name")

private String employeeName;

@Column(name="company_id")
private Integer companyId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id", nullable=false,insertable = false ,updatable = false)
    @JsonBackReference
    Company company;


}
