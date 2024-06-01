package com.project.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employee.model.Employee;
import com.project.employee.service.EmployeeService;

@RestController
public class EmployeeControllerApi {

    @Autowired
    private EmployeeService service;

    
    @GetMapping("/displayAll")
    public List<Employee> viewHomePage(Model model) {
    	return service.getAllEmployees();
    }


    @PostMapping("/saveEmployeeDetail")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.saveEmployee(employee);
        return "Saved Successfully";
    }

    @GetMapping("/display/{id}")
    public Employee editEmployeeForm(@PathVariable("id") String id, Model model) {
        return service.getEmployeeById(id).orElse(new Employee());
    }

    @PostMapping("/updateEmployeeDetailById/{id}")
    public String updateEmployee(@PathVariable("id") String id, @ModelAttribute("employee") Employee employee) {
//        employee.setEmployeeID(id);
        service.saveEmployee(employee);
        return "Updated Successfully";
    }

    @GetMapping("/deleteEmployeeDetailById/{id}")
    public String deleteEmployee(@PathVariable("id") String id) {
        service.deleteEmployee(id);
        return "Deleted Successfully";
    }
}
