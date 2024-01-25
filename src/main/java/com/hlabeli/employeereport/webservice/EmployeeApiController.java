package com.hlabeli.employeereport.webservice;

import com.hlabeli.employeereport.persistence.entity.EmployeeEntity;
import com.hlabeli.employeereport.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeApiController {

    private final IEmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeEntity>> findAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

}
