package com.hlabeli.employeereport.service.impl;

import com.hlabeli.employeereport.persistence.entity.EmployeeEntity;
import com.hlabeli.employeereport.service.IEmployeeService;
import com.hlabeli.employeereport.service.IEmployeeReportService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeReportImpl implements IEmployeeReportService {

    private final IEmployeeService employeeService;

    static final String HTML = "html";
    static final String PDF = "pdf";
    static final String PATH = System.getProperty("user.home") + "/Downloads/";
    @Override
    public String employeeReport(String format) throws FileNotFoundException, JRException {

        List<EmployeeEntity> employees = employeeService.findAll();

        File file = ResourceUtils.getFile("classpath:reports/employees.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, null, dataSource);

        if (format.equalsIgnoreCase(HTML)) {
            JasperExportManager.exportReportToHtmlFile(print, PATH + "employees.html");
        } else if (format.equalsIgnoreCase(PDF)) {
            JasperExportManager.exportReportToPdfFile(print, PATH + "employees.pdf");
        }

        return "File generated successfully, please check " + PATH;
    }
}
