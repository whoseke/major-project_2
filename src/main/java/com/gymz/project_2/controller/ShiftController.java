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

    @GetMapping("/admin/create/shift")
    public String createShift(Model model) {
        List<Employee> employee = employeeService.getAllEmployees();

        model.addAttribute("newShift", new Shift());
        model.addAttribute("employee", employee);
        return "layout/admin/shift/create_shift";
    }

    @PostMapping(value = "/admin/createShift")
    public String getShift(Model model, @ModelAttribute("newShift") Shift shift) {
        this.shiftService.handleShift(shift);
        return "redirect:/admin/shift";
    }

    @GetMapping("/admin/shift")
    public String showshift(Model model) {
        List<Shift> shifts = this.shiftService.getAllShift();

        model.addAttribute("shifts", shifts);
        return "layout/admin/shift/show_shift";
    }

    @GetMapping("/admin/update/shift/{id}")
    public String setUpdateShift(Model model, @PathVariable long id) {
        List<Employee> employee = employeeService.getAllEmployees();

        Shift currentShift = this.shiftService.getShiftByID(id);
        model.addAttribute("newShift", currentShift);
        model.addAttribute("employee", employee);
        return "layout/admin/shift/update_shift";
    }

    @PostMapping("/admin/update/shift")
    public String getUpdateShift(Model model, @ModelAttribute("newShift") Shift currentShift) {

        Shift newShift = this.shiftService.getShiftByID(currentShift.getShift_id());
        if (newShift != null) {
            newShift.setEmployee(currentShift.getEmployee());
            newShift.setShift_date(currentShift.getShift_date());
            newShift.setStart_time(currentShift.getStart_time());
            newShift.setEnd_time(currentShift.getEnd_time());
            this.shiftService.handleShift(newShift);
        }
        return "redirect:/admin/shift";

    }

    @GetMapping("/admin/delete/shift/{id}")
    public String deleteShift(Model model, @PathVariable long id) {
        this.shiftService.deleteShiftById(id);
        return "redirect:/admin/shift";
    }

    // shift_role

    @GetMapping("/info/shift")
    public String showshiftbyEmployee(Model model) {
        List<Shift> shifts = this.shiftService.getAllShift();

        model.addAttribute("shifts", shifts);
        return "shift/show_shift";
    }
}
