package com.gymz.project_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String getHomePage() {
        return "homePage";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        return "client/login";
    }

    @GetMapping("/registry")
    public String getRegistry(Model model) {
        return "client/registry";
    }
}
