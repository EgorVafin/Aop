package com.example.testaop.service;

import com.example.testaop.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    //return employee object
    public Employee getEmployee() throws EmployeeServiceException {
        Employee employee = new Employee();
        employee.setName("Anna");
        employee.setDesignation("HR manager");
        employee.setEmpId("1");
        employee.setSalary(5700);

        return employee;
    }

    //return employee as null
    public Employee getEmployeeNull() throws EmployeeServiceException {

        return null;
    }

    //throw exception
    public Employee getEmployeeException() throws EmployeeServiceException {

        throw new EmployeeServiceException();
    }
}
