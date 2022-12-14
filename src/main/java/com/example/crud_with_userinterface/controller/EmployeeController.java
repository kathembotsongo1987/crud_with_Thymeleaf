package com.example.crud_with_userinterface.controller;

import com.example.crud_with_userinterface.model.Employee;
import com.example.crud_with_userinterface.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    //Create a handler method that is going to handle the update event
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model){
        //get Employee from the service
        Employee employee = employeeService.getEmployeeById(id);
        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_Employee";
    }
    //create a handler with deleteEmployee Method that is going to handle the delevent event
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
        //Call deleteEmployee method from the service
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
