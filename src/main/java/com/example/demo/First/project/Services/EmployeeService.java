package com.example.demo.First.project.Services;

import com.example.demo.First.project.bean.EmployeeBean;
import com.example.demo.First.project.entity.Employee;
import com.example.demo.First.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
   EmployeeRepository employeeRepository;


    public List<Employee> detailEmployee() {

        return employeeRepository.findAll();

    }


    public List<Employee> allDetailEmployee(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName);

    }


    public boolean addData(EmployeeBean employeeBean) {

        try {

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
                Employee saveEmployee = employeeRepository.saveAndFlush(emp);
                System.out.println("EmployeeId Not found");
                return true;
            }
        } catch (Exception e) {
//            return false;
            throw new RuntimeException(e);
        }
        return true;
    }
    public boolean updateDetail(EmployeeBean employeeBean){
        if(Objects.nonNull(employeeBean.getEmployeeId())){
            Optional<Employee> empData=employeeRepository.findById(employeeBean.getEmployeeId());
            Employee getData=empData.get();
            getData.setEmployeeId(employeeBean.getEmployeeId());
            getData.setEmployeeName(employeeBean.getEmployeeName());
            getData.setCompanyId(employeeBean.getCompanyId());
            Employee update  =employeeRepository.save(getData);
            return true;
        }
        else {
            return false;
        }

    }


    public boolean deleteEmployee(EmployeeBean employeeBean) {
        if(Objects.nonNull(employeeBean.getEmployeeId())){
            Optional<Employee> empData=employeeRepository.findById(employeeBean.getEmployeeId());
            Employee getData=empData.get();
            getData.setEmployeeId(employeeBean.getEmployeeId());
            employeeRepository.deleteById(getData.getEmployeeId());
        }

        else {
            return false;
        }
        return true;
    }

    public void deleteId(int employeeId){

        employeeRepository.deleteById(employeeId);
    }

    public Page<Employee> getDetail(Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable=null;
        if(null!=sortProperty){
            pageable= PageRequest.of(pageNumber,pageSize, Sort.Direction.DESC,sortProperty);

        }
        else {
            pageable= PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC,"employeeID");

        }
        return employeeRepository.findAll(pageable);
    }




//    public  boolean display(EmployeeBean employeeBean){
//
//        List<Employee> data =employeeRepository.findAll();
//
//      JSONObject jsonObject=(JSONObject)data;
//        Gson gson = new Gson();
//        JSONObject jsonObject= new JSONObject(employeeBean);
//
//        Employee data = (Employee) jsonObject.get(String.valueOf(employeeBean));
//        Optional<Employee> empData=employeeRepository.findById(employeeBean.getEmployeeId());
//
//
//
//
//    }

}



