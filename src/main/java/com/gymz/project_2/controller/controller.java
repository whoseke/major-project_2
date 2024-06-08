package com.gymz.project_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gymz.project_2.domain.Account;

@Controller
public class controller {

    @RequestMapping("/")
    public String getHomePage() {
        return "hello";
    }

    // @RequestMapping(value = "/admin/user", method = RequestMethod.POST)
    @RequestMapping("/admin/user")
    public String getCreateUser() {
        return "/admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
    public String getCreateUser1(Model model) {
        model.addAttribute("newUser", new Account());
        return "hello";
    }
}
