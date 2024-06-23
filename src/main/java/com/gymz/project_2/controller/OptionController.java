package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gymz.project_2.domain.OptionGym;
import com.gymz.project_2.service.OptionService;

@Controller
public class OptionController {
    private OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/create/option")
    public String createOption(Model model) {
        model.addAttribute("newOption", new OptionGym());
        return "option/create_option";
    }

    @PostMapping(value = "/create/createOption")
    public String getOption(Model model, @ModelAttribute("newOption") OptionGym op) {
        this.optionService.handleSaveOption(op);
        return "redirect:/info/option";
    }

    @GetMapping("/info/option")
    public String showoption(Model model) {
        List<OptionGym> options = this.optionService.getAllOption();
        model.addAttribute("options", options);
        return "option/show_option";
    }

    @GetMapping("/update/option/{id}")
    public String setUpdateOption(Model model, @PathVariable long id) {
        OptionGym currentOP = this.optionService.getOptionGymByID(id);
        model.addAttribute("newOption", currentOP);
        return "option/update_option";
    }

    @PostMapping("/update/option")
    public String getUpdateOption(Model model, @ModelAttribute("newOption") OptionGym currentOP) {
        OptionGym newOP = this.optionService.getOptionGymByID(currentOP.getOp_id());
        if (newOP != null) {
            newOP.setName(currentOP.getName());
            newOP.setDuration(currentOP.getDuration());
            newOP.setPrice(currentOP.getPrice());
            this.optionService.handleSaveOption(newOP);
        }
        return "redirect:/info/option";
    }

    @GetMapping("/delete/option/{id}")
    public String deleteBooking(Model model, @PathVariable long id) {
        this.optionService.deleteOptionById(id);
        return "redirect:/info/option";
    }
}
