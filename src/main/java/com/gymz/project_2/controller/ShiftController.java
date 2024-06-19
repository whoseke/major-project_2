package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gymz.project_2.domain.Employee;
import com.gymz.project_2.domain.Shift;
import com.gymz.project_2.service.EmployeeService;
import com.gymz.project_2.service.ShiftService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShiftController {
    private final ShiftService shiftService;
    private final EmployeeService employeeService;

    public ShiftController(ShiftService shiftService, EmployeeService employeeService) {
        this.shiftService = shiftService;
        this.employeeService = employeeService;
    }

    @GetMapping("/create/shift")
    public String createShift(Model model) {
        List<Employee> employee = employeeService.getAllEmployees();

        model.addAttribute("newShift", new Shift());
        model.addAttribute("employee", employee);
        return "admin/user/employee/create/shift";
    }

    @PostMapping(value = "/create/createShift")
    public String getShift(Model model, @ModelAttribute("newShift") Shift shift) {
        this.shiftService.handleShift(shift);
        return "redirect:/info/shift";
    }

    @GetMapping("/info/shift")
    public String showshift(Model model) {
        List<Shift> shifts = this.shiftService.getAllShift();

        model.addAttribute("shifts", shifts);
        return "admin/user/employee/show/shift";
    }

    @GetMapping("/update/shift/{id}")
    public String setUpdateShift(Model model, @PathVariable long id) {
        List<Employee> employee = employeeService.getAllEmployees();

        Shift currentShift = this.shiftService.getShiftByID(id);
        model.addAttribute("newShift", currentShift);
        model.addAttribute("employee", employee);
        return "admin/user/employee/update/shift";
    }

    @PostMapping("/update/shift")
    public String getUpdateShift(Model model, @ModelAttribute("newShift") Shift currenShift) {

        Shift newShift = this.shiftService.getShiftByID(currenShift.getShift_id());
        if (newShift != null) {
            newShift.setEmployee(currenShift.getEmployee());
            newShift.setShift_date(currenShift.getShift_date());
            newShift.setStart_time(currenShift.getStart_time());
            newShift.setEnd_time(currenShift.getEnd_time());
            this.shiftService.handleShift(newShift);
        }
        return "redirect:/info/shift";

    }

    @GetMapping("/delete/shift/{id}")
    public String deleteShift(Model model, @PathVariable long id) {
        this.shiftService.deleteShiftById(id);
        return "redirect:/info/shift";
    }
}
