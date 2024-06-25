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

    @GetMapping("/admin/create/employee")
    public String createEmployee(Model model) {
        model.addAttribute("newEmployee", new Employee());
        return "layout/admin/employee/create_employee";
    }

    @PostMapping(value = "/admin/createEmployee")
    public String getEmployee(Model model, @ModelAttribute("newEmployee") Employee employee) {
        this.employeeService.handEmployee(employee);
        return "redirect:/admin/employee";
    }

    @GetMapping("/admin/employee")
    public String showEmployee(Model model) {
        List<Employee> employees = this.employeeService.getAllEmployees();

        model.addAttribute("employees", employees);
        return "layout/admin/employee/show_employee";
    }

    @GetMapping("/admin/update/employee/{id}")
    public String getUpdateEmployee(Model model, @PathVariable long id) {
        Employee currentEmployee = this.employeeService.getEmployeeByID(id);
        model.addAttribute("newEmployee", currentEmployee);
        return "layout/admin/employee/update_employee";
    }

    @PostMapping("/admin/update/employee")
    public String setUpdateEmployee(Model model, @ModelAttribute("newEmployee") Employee currentAccount) {
        Employee newEmployee = this.employeeService.getEmployeeByID(currentAccount.getEmployee_id());
        if (newEmployee != null) {
            newEmployee.setEmployee_id(currentAccount.getEmployee_id());
            newEmployee.setName(currentAccount.getName());
            newEmployee.setPosition(currentAccount.getPosition());
            newEmployee.setSalary(currentAccount.getSalary());
            this.employeeService.handEmployee(newEmployee);
        }
        return "redirect:/admin/employee";
    }

    @GetMapping("/admin/delete/employee/{id}")
    public String deleteBooking(Model model, @PathVariable long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/admin/employee";
    }
}
