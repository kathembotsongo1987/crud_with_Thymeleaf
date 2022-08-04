package com.example.crud_with_userinterface.service;

import com.example.crud_with_userinterface.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    //create a save method to create employee
    void saveEmployee(Employee employee);
}
