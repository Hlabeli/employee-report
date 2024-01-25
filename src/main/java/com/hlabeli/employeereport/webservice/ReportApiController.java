package com.hlabeli.employeereport.webservice;

import com.hlabeli.employeereport.service.IEmployeeReportService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequiredArgsConstructor
public class ReportApiController {

    private final IEmployeeReportService employeeReportService;

    @GetMapping("reports")
    public ResponseEntity<String> employeeReports(@RequestParam String format) throws FileNotFoundException, JRException {
        return new ResponseEntity<>(employeeReportService.employeeReport(format), HttpStatus.OK);
    }
}
