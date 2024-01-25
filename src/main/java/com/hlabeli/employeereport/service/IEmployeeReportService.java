package com.hlabeli.employeereport.service;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface IEmployeeReportService {
    public String employeeReport(String format) throws FileNotFoundException, JRException;
}
