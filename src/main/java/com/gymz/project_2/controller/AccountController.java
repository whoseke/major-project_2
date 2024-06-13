package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gymz.project_2.domain.Account;
import com.gymz.project_2.service.AccountService;

@Controller
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/create/account")
    public String getCreateUser(Model model) {
        model.addAttribute("newAccount", new Account());

        return "/create/account";
    }

    @RequestMapping(value = "/create/createAccount", method = RequestMethod.POST)
    public String getCreateUser1(Model model, @ModelAttribute("newAccount") Account account) {
        System.out.println("run here " + account);
        this.accountService.handleSaveAccount(account);
        return "redirect:/show/account";
    }

    @RequestMapping("/info/account")
    public String showAccount(Model model) {
        List<Account> accounts = this.accountService.getAllAccount();

        model.addAttribute("accounts", accounts);
        return "/show/account";
    }

}
