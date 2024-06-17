package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gymz.project_2.domain.Employee;
import com.gymz.project_2.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/create/employee")
    public String createEmployee(Model model) {
        model.addAttribute("newEmployee", new Employee());
        return "/create/employee";
    }

    @PostMapping(value = "/create/createEmployee")
    public String getEmployee(Model model, @ModelAttribute("newEmployee") Employee employee) {
        this.employeeService.handEmployee(employee);
        return "redirect:/info/employee";
    }

    @GetMapping("/info/employee")
    public String showEmployee(Model model) {
        List<Employee> employees = this.employeeService.getAllEmployees();

        model.addAttribute("employees", employees);
        return "/show/employee";
    }

    @GetMapping("/update/employee/{id}")
    public String getUpdateEmployee(Model model, @PathVariable long id) {
        Employee currentEmployee = this.employeeService.getEmployeeByID(id);
        model.addAttribute("newEmployee", currentEmployee);
        return "/update/employee";
    }

    @PostMapping("/update/employee")
    public String setUpdateEmployee(Model model, @ModelAttribute("newEmployee") Employee currentAccount) {
        Employee newEmployee = this.employeeService.getEmployeeByID(currentAccount.getEmployee_id());
        if (newEmployee != null) {
            newEmployee.setEmployee_id(currentAccount.getEmployee_id());
            newEmployee.setName(currentAccount.getName());
            newEmployee.setPosition(currentAccount.getName());
            newEmployee.setSalary(currentAccount.getSalary());
            this.employeeService.handEmployee(newEmployee);
        }
        return "redirect:/info/employee";
    }

    @GetMapping("/delete/employee/{id}")
    public String deleteBooking(Model model, @PathVariable long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/info/employee";
    }
}
