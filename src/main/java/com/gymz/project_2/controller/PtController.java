package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gymz.project_2.domain.Pt;
import com.gymz.project_2.service.PtService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PtController {
    private final PtService ptService;

    public PtController(PtService ptService) {
        this.ptService = ptService;
    }

    @RequestMapping("/create/pt")
    public String createPt(Model model) {
        model.addAttribute("newPT", new Pt());
        return "create/pt";
    }

    @RequestMapping(value = "/create/createPT", method = RequestMethod.POST)
    public String getPt(Model model, @ModelAttribute("newPT") Pt pt) {
        this.ptService.handlePt(pt);
        return "redirect:/info/pt";
    }

    @RequestMapping("/info/pt")
    public String showPt(Model model) {
        List<Pt> pts = this.ptService.getAllPt();

        model.addAttribute("pts", pts);
        return "/show/pt";
    }
}
