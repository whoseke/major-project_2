package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gymz.project_2.domain.Account;
import com.gymz.project_2.domain.AccountRole;
import com.gymz.project_2.service.AccountRoleService;
import com.gymz.project_2.service.AccountService;

@Controller
public class AccountController {

    private final AccountService accountService;
    private final AccountRoleService accountRoleService;
    private final PasswordEncoder bCryptPasswordEncoder;

    public AccountController(AccountService accountService, AccountRoleService accountRoleService,
            PasswordEncoder bCryptPasswordEncoder) {
        this.accountService = accountService;
        this.accountRoleService = accountRoleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/create/account")
    public String getCreateUser(Model model) {
        List<AccountRole> role = this.accountRoleService.getAllRole();
        model.addAttribute("role", role);
        model.addAttribute("newAccount", new Account());
        return "account/create_account";
    }

    @PostMapping(value = "/create/createAccount")
    public String getCreateUser1(Model model, @ModelAttribute("newAccount") Account account) {
        System.out.println("run here " + account);
        String hashPassword = this.bCryptPasswordEncoder.encode(account.getPassword());
        account.setPassword(hashPassword);
        this.accountService.handleSaveAccount(account);
        return "redirect:/info/account";
    }

    @GetMapping("/info/account")
    public String showAccount(Model model) {
        List<Account> accounts = this.accountService.getAllAccount();

        model.addAttribute("accounts", accounts);
        return "account/show_account";
    }

    @GetMapping("/update/account/{id}")
    public String getCreateUser(Model model, @PathVariable long id) {
        Account currentAccount = this.accountService.getAccountByID(id);
        List<AccountRole> role = accountRoleService.getAllRole();
        model.addAttribute("role", role);
        model.addAttribute("newAccount", currentAccount);
        return "account/update_account";
    }

    @PostMapping("/update/account")
    public String setUpdateAccount(Model model, @ModelAttribute("newAccount") Account currentAccount) {
        Account newAccount = this.accountService.getAccountByID(currentAccount.getAccount_id());
        if (newAccount != null) {
            String hashPassword = this.bCryptPasswordEncoder.encode(currentAccount.getPassword());
            newAccount.setPassword(hashPassword);
            newAccount.setRole(currentAccount.getRole());
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