package com.hlabeli.employeereport.service.impl;

import com.hlabeli.employeereport.persistence.entity.EmployeeEntity;
import com.hlabeli.employeereport.persistence.repository.IEmployeeRepository;
import com.hlabeli.employeereport.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }
}
