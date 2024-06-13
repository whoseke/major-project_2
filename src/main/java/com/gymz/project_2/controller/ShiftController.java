package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gymz.project_2.domain.Account;
import com.gymz.project_2.domain.Employee;
import com.gymz.project_2.domain.Shift;
import com.gymz.project_2.service.EmployeeService;
import com.gymz.project_2.service.ShiftService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShiftController {
    private final ShiftService shiftService;
    private final EmployeeService employeeService;

    public ShiftController(ShiftService shiftService, EmployeeService employeeService) {
        this.shiftService = shiftService;
        this.employeeService = employeeService;
    }

    @RequestMapping("/create/shift")
    public String createShift(Model model) {
        List<Employee> employee = employeeService.getAllEmployees();

        model.addAttribute("newShift", new Shift());
        model.addAttribute("employee", employee);
        return "create/shift";
    }

    @RequestMapping(value = "/create/createShift", method = RequestMethod.POST)
    public String getShift(Model model, @ModelAttribute("newShift") Shift shift) {
        this.shiftService.handleShift(shift);
        return "redirect:/info/shift";
    }

    @RequestMapping("/info/shift")
    public String showshift(Model model) {
        List<Shift> shifts = this.shiftService.getAllShift();

        model.addAttribute("shifts", shifts);
        return "/show/shift";
    }

}
