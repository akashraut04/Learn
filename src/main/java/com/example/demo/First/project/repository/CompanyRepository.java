package com.example.demo.First.project.repository;

import com.example.demo.First.project.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
