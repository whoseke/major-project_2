package com.gymz.project_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
    @RequestMapping("/")
    public String getHomePage() {
        return "homePage";
    }
}
