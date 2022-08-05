package com.example.crud_with_userinterface.service;

import com.example.crud_with_userinterface.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    //create a save method to create employee
    void saveEmployee(Employee employee);
    // create update with a getEmployee method
    Employee getEmployeeById(long id);
    //create a delete method to delete de Employee
    void deleteEmployeeById(long id);

}
