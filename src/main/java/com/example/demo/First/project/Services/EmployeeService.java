package com.example.demo.First.project.Services;

import com.example.demo.First.project.bean.EmployeeBean;
import com.example.demo.First.project.entity.Employee;
import com.example.demo.First.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
   EmployeeRepository employeeRepository;


    public List<Employee> alldetailEmployee(String employeeName) {
       return employeeRepository.findByEmployeeName(employeeName);

    }


    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public boolean addData(EmployeeBean employeeBean) {

        if(Objects.nonNull(employeeBean.getEmployeeId())){
            Optional<Employee> empData=employeeRepository.findById(employeeBean.getEmployeeId());
            Employee getData=empData.get();
            getData.setEmployeeId(employeeBean.getEmployeeId());
            getData.setEmployeeName(employeeBean.getEmployeeName());
            getData.setCompanyId(employeeBean.getCompanyId());
            Employee update  =employeeRepository.save(getData);

        }else {
            Employee emp = new Employee();
            emp.setEmployeeName(employeeBean.getEmployeeName());
            emp.setCompanyId(employeeBean.getCompanyId());
            Employee saveEmployee = employeeRepository.save(emp);

        }
        return true;
    }

}



