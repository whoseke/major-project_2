package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gymz.project_2.domain.Pt;
import com.gymz.project_2.service.PtService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PtController {
    private final PtService ptService;

    public PtController(PtService ptService) {
        this.ptService = ptService;
    }

    @GetMapping("/create/pt")
    public String createPt(Model model) {
        model.addAttribute("newPT", new Pt());
        return "admin/user/employee/create/pt/pt";
    }

    @PostMapping(value = "/create/createPT")
    public String getPt(Model model, @ModelAttribute("newPT") Pt pt) {
        this.ptService.handlePt(pt);
        return "redirect:/info/pt";
    }

    @GetMapping("/info/pt")
    public String showPt(Model model) {
        List<Pt> pts = this.ptService.getAllPt();

        model.addAttribute("pts", pts);
        return "admin/user/employee/show/pt/pt";
    }

    @GetMapping("/update/pt/{id}")
    public String getUpdatePt(Model model, @PathVariable long id) {
        Pt currentPt = this.ptService.getPtByID(id);
        model.addAttribute("newPT", currentPt);
        return "admin/user/employee/update/pt/pt";
    }

    @PostMapping("/update/pt")
    public String setUpdatePt(Model model, @ModelAttribute("newPT") Pt currentPt) {
        Pt newPt = this.ptService.getPtByID(currentPt.getPt_id());
        if (newPt != null) {
            newPt.setName(currentPt.getName());
            newPt.setSpecialization(currentPt.getSpecialization());
            newPt.setPhoneNumber(currentPt.getPhoneNumber());
            newPt.setExperience_year(currentPt.getExperience_year());
            newPt.setDate_joined(currentPt.getDate_joined());
            this.ptService.handlePt(newPt);
        }
        return "redirect:/info/pt";
    }

    @GetMapping("/delete/pt/{id}")
    public String deletePt(Model model, @PathVariable long id) {
        this.ptService.deleteById(id);
        return "redirect:/info/pt";
    }
}
