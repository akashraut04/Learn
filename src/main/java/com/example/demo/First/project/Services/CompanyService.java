package com.example.demo.First.project.Services;

import com.example.demo.First.project.bean.CompanyBean;
import com.example.demo.First.project.entity.Company;
import com.example.demo.First.project.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;


    public boolean addCompany(CompanyBean companyBean) {

        if(Objects.nonNull(companyBean.getCompanyId())){
            Optional<Company>companyData=companyRepository.findById(companyBean.getCompanyId());
            Company getData=companyData.get();
            getData.setCompanyId(companyBean.getCompanyId());
            getData.setCompanyName(companyBean.getCompanyName());
            getData.setDesignation(companyBean.getDesignation());
            Company update =companyRepository.save(getData);
        }else {
            Company comp=new Company();
            comp.setCompanyName(companyBean.getCompanyName());
            comp.setDesignation(companyBean.getDesignation());
            Company saveCompany=companyRepository.save(comp);
        }
        return true;
    }



}
