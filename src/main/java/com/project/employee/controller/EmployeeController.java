package com.project.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.employee.model.Employee;
import com.project.employee.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
	public String showHome(Model model) {
    	model.addAttribute("allEmployees", service.getAllEmployees());
    	 model.addAttribute("employee", new Employee());
		return "home";
	}
    
    @GetMapping("/displayAllEmployees")
    public String viewHomePage(Model model) {
        model.addAttribute("allEmployees", service.getAllEmployees());
        return "home";
    }

    @GetMapping("/addEmployee")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/getEmployeeById/{id}")
    public String editEmployeeForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("employee", service.getEmployeeById(id).orElse(new Employee()));
        return "editEmployee";
    }

    @PostMapping("/updateEmployeeById/{id}")
    public String updateEmployee(@PathVariable("id") String id, @ModelAttribute("employee") Employee employee) {
//        employee.setEmployeeID(id);
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/deleteEmployeeById/{id}")
    public String deleteEmployee(@PathVariable("id") String id) {
        service.deleteEmployee(id);
        return "redirect:/";
    }
}
