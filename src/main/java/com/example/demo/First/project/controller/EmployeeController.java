package com.example.demo.First.project.controller;

import com.example.demo.First.project.Services.EmployeeService;
import com.example.demo.First.project.bean.EmployeeBean;
import com.example.demo.First.project.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(path="/all")

    public List<Employee> detailEmployee()
    {
        return employeeService.detailEmployee();
    }


    @GetMapping(path="/name/{name}")
    public List<Employee> getDetail(@PathVariable("name") String employeeName)
    {
        return employeeService.allDetailEmployee(employeeName);
    }

    @PostMapping(path="/post")
    public boolean addDetail(@RequestBody EmployeeBean employeeBean) {

        return   employeeService.addData(employeeBean);

    }

    @PutMapping(path="/put")
    public boolean updateData(@RequestBody EmployeeBean employeeBean) {

      return   employeeService.updateDetail(employeeBean);

    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteDetail(@PathVariable("id") int employeeId)
    {
        employeeService.deleteId(employeeId);
    }

    @RequestMapping(value = "/value/{pageNumber}/{pageSize}/{sortProperty}",method = RequestMethod.GET)
    public Page<Employee> getData(@PathVariable Integer pageNumber,
                                  @PathVariable Integer pageSize,
                                  @PathVariable String sortProperty){

        return employeeService.getDetail(pageNumber,pageSize,sortProperty);
    }
}
