package com.example.testaop.controller;

import com.example.testaop.model.Employee;
import com.example.testaop.service.EmployeeService;
import com.example.testaop.service.EmployeeServiceException;
import com.example.testaop.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Happy path, an employee is returned as response
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public Employee getEmpl() throws ResourceNotFoundException, EmployeeServiceException {
        try {
            Employee employee = employeeService.getEmployee();

            if (employee == null) {
                throw new ResourceNotFoundException("Employee not found");
            }
            return employee;
        } catch (EmployeeServiceException e) {
            throw new EmployeeServiceException("Internal Server Exception while getting exception");
        }
    }

    //no employee found so ResourceNotFoundException is thrown
    @RequestMapping(value = "/employee2", method = RequestMethod.GET)
    public Employee getEmp2() throws ResourceNotFoundException, EmployeeServiceException {
        try {
            Employee employee = employeeService.getEmployeeNull();
            if (employee == null) {
                throw new ResourceNotFoundException("Employee not found");
            }

            return employee;
        } catch (EmployeeServiceException e) {
            throw new EmployeeServiceException("Internal Server Exception while getting exception");
        }
    }

    //Some exception is thrown by service layer
    @RequestMapping(value = "/employee3", method = RequestMethod.GET)
    public Employee getEmp3() throws ResourceNotFoundException, EmployeeServiceException {
        try {
            Employee exception = employeeService.getEmployeeException();
            if (exception == null) {
                throw new ResourceNotFoundException("Employee not found");
            }
            return exception;
        } catch (EmployeeServiceException e) {
            throw new EmployeeServiceException("Internal Server Exception while getting exception");
        }
    }
}
