package com.example.demo.First.project.repository;

import com.example.demo.First.project.bean.EmployeeBean;
import com.example.demo.First.project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Integer> {
    public List<Employee>findByEmployeeName(String employeeName);


}
