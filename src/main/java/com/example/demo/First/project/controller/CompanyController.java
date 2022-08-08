package com.example.demo.First.project.controller;

import com.example.demo.First.project.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public class CompanyController {

    @Autowired
    CompanyService companyService;


}
