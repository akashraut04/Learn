package com.example.demo.First.project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="company_Id")
    private int companyId;
    @Column(name="designation")
    private String designation;
    @Column(name="company_Name")
    private String companyName;

    @OneToMany(mappedBy = "company", cascade = {CascadeType.ALL})
    @JsonManagedReference
    List<Employee> employees;
}
