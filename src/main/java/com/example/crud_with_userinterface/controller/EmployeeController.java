package com.example.crud_with_userinterface.controller;

import com.example.crud_with_userinterface.model.Employee;
import com.example.crud_with_userinterface.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@SuppressWarnings("ALL")
@Controller
public class EmployeeController {
    //display list of Employees
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")

    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }
    //write a handler method to handle this button
    @GetMapping("/showNewEmployeeForm")
    public  String showNewEmployeeForm(Model model){
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return  "new_Employee";
    }
    @PostMapping("/saveEmployee")
    public  String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
}
