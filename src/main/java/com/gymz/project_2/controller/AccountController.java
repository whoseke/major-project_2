package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gymz.project_2.domain.Account;
import com.gymz.project_2.service.AccountService;

@Controller
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/create/account")
    public String getCreateUser(Model model) {
        model.addAttribute("newAccount", new Account());

        return "/create/account";
    }

    @PostMapping(value = "/create/createAccount")
    public String getCreateUser1(Model model, @ModelAttribute("newAccount") Account account) {
        System.out.println("run here " + account);
        this.accountService.handleSaveAccount(account);
        return "redirect:/info/account";
    }

    @GetMapping("/info/account")
    public String showAccount(Model model) {
        List<Account> accounts = this.accountService.getAllAccount();

        model.addAttribute("accounts", accounts);
        return "/show/account";
    }

    @GetMapping("/update/account/{id}")
    public String getCreateUser(Model model, @PathVariable long id) {
        Account currentAccount = this.accountService.getAccountByID(id);
        model.addAttribute("newAccount", currentAccount);
        return "/update/account";
    }

    @PostMapping("/update/account")
    public String setUpdateAccount(Model model, @ModelAttribute("newAccount") Account currentAccount) {
        Account newAccount = this.accountService.getAccountByID(currentAccount.getAccount_id());
        if (newAccount != null) {
            newAccount.setPassword(currentAccount.getPassword());
            newAccount.setAccountType(currentAccount.getAccountType());
            this.accountService.handleSaveAccount(newAccount);
        }
        return "redirect:/info/account";
    }

    @GetMapping("/delete/account/{id}")
    public String deleteAccount(Model model, @PathVariable long id) {
        this.accountService.deleteAccountById(id);
        return "redirect:/info/account";
    }

}