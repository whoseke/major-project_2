package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gymz.project_2.domain.Employee;
import com.gymz.project_2.service.EmployeeService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/create/employee")
    public String createEmployee(Model model) {
        model.addAttribute("newEmployee", new Employee());
        return "/create/employee";
    }

    @RequestMapping(value = "/create/createEmployee", method = RequestMethod.POST)
    public String getEmployee(Model model, @ModelAttribute("newEmployee") Employee employee) {
        this.employeeService.handEmployee(employee);
        return "redirect:/show/employee";
    }

    @RequestMapping("/info/employee")
    public String showEmployee(Model model) {
        List<Employee> employees = this.employeeService.getAllEmployees();

        model.addAttribute("employees", employees);
        return "/show/employee";
    }

}
