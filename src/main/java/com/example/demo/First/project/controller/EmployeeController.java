package com.example.demo.First.project.controller;

import com.example.demo.First.project.Services.EmployeeService;
import com.example.demo.First.project.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @GetMapping(path="/name/{name}")
    public List<Employee> getDetail(@PathVariable("name") String employeeName)
    {
    return employeeService.alldetailEmployee(employeeName);
    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteDetail(@PathVariable("id")int employeeId)
    {
      employeeService.deleteEmployee(employeeId);
    }
}
