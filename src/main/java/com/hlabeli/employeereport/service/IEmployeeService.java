package com.hlabeli.employeereport.service;

import com.hlabeli.employeereport.persistence.entity.EmployeeEntity;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeEntity> findAll();
}
