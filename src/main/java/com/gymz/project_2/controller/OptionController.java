package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gymz.project_2.domain.OptionGym;
import com.gymz.project_2.service.OptionService;

@Controller
public class OptionController {
    private OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @RequestMapping("/create/option")
    public String createOption(Model model) {
        model.addAttribute("newOption", new OptionGym());
        return "/create/option";
    }

    @RequestMapping(value = "/create/createOption", method = RequestMethod.POST)
    public String getOption(Model model, @ModelAttribute("newOption") OptionGym op) {
        System.out.println("run here " + op);
        this.optionService.handleSaveOption(op);
        return "redirect:/info/option";
    }

    @RequestMapping("/info/option")
    public String showoption(Model model) {
        List<OptionGym> options = this.optionService.getAllOption();

        model.addAttribute("options", options);
        return "/show/option";
    }
}
