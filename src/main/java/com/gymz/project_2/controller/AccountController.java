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
import com.gymz.project_2.domain.Employee;
import com.gymz.project_2.domain.Member;
import com.gymz.project_2.domain.Pt;
import com.gymz.project_2.service.AccountRoleService;
import com.gymz.project_2.service.AccountService;
import com.gymz.project_2.service.CustomUserDetailsService;
import com.gymz.project_2.service.EmployeeService;
import com.gymz.project_2.service.MemberService;
import com.gymz.project_2.service.PtService;

@Controller
public class AccountController {

    private final AccountService accountService;
    private final AccountRoleService accountRoleService;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final CustomUserDetailsService customUserDetailsService;
    private final EmployeeService employeeService;
    private final PtService ptService;
    private final MemberService memberService;

    public AccountController(AccountService accountService, AccountRoleService accountRoleService,
            PasswordEncoder bCryptPasswordEncoder, CustomUserDetailsService customUserDetailsService,
            EmployeeService employeeService, PtService ptService, MemberService memberService) {
        this.accountService = accountService;
        this.accountRoleService = accountRoleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.customUserDetailsService = customUserDetailsService;
        this.employeeService = employeeService;
        this.ptService = ptService;
        this.memberService = memberService;
    }

    @GetMapping("/admin/create/account")
    public String getCreateUser(Model model) {
        List<AccountRole> role = this.accountRoleService.getAllRole();
        List<Pt> pts = ptService.getAllPt();
        List<Member> members = memberService.getAllMember();
        List<Employee> employees = employeeService.getAllEmployees();

        model.addAttribute("role", role);
        model.addAttribute("employees", employees);
        model.addAttribute("pts", pts);
        model.addAttribute("members", members);
        model.addAttribute("newAccount", new Account());
        return "layout/admin/account/create_account";
    }

    @PostMapping(value = "/admin/create/createAccount")
    public String getCreateUser1(Model model, @ModelAttribute("newAccount") Account account) {

        String hashPassword = this.bCryptPasswordEncoder.encode(account.getPassword());
        account.setPassword(hashPassword);
        this.accountService.handleSaveAccount(account);
        return "redirect:/admin/account";
    }

    @GetMapping("/admin/account")
    public String showAccount(Model model) {
        List<Account> accounts = this.accountService.getAllAccount();

        model.addAttribute("accounts", accounts);
        return "layout/admin/account/show_account";
    }

    @GetMapping("/admin/update/account/{id}")
    public String getUpdateUser(Model model, @PathVariable long id) {
        Account currentAccount = this.accountService.getAccountByID(id);
        List<AccountRole> role = accountRoleService.getAllRole();
        model.addAttribute("role", role);
        model.addAttribute("newAccount", currentAccount);
        return "layout/admin/account/update_account";
    }

    @PostMapping("/admin/update/account")
    public String setUpdateAccount(Model model, @ModelAttribute("newAccount") Account currentAccount) {
        Account newAccount = this.accountService.getAccountByID(currentAccount.getAccount_id());
        if (newAccount != null) {
            String hashPassword = this.bCryptPasswordEncoder.encode(currentAccount.getPassword());
            newAccount.setPassword(hashPassword);
            newAccount.setRole(currentAccount.getRole());
            this.accountService.handleSaveAccount(newAccount);
        }
        return "redirect:/admin/account";
    }

    @GetMapping("/admin/delete/account/{id}")
    public String deleteAccount(Model model, @PathVariable long id) {
        this.accountService.deleteAccountById(id);
        return "redirect:/admin/account";
    }

    // pt_role
    @GetMapping("/pt/account")
    public String showAccountByPT(Model model) {
        String username = customUserDetailsService.getCurrentUsername();
        Account accounts = accountService.getAccountByUser(username);
        System.out.println("zzzzzzzzzzzzzzzzzz " + accounts);
        model.addAttribute("accounts", accounts);
        return "layout/pt/account/show_account";
    }

    @GetMapping("/pt/update/account/{id}")
    public String getUpdateUserByPT(Model model, @PathVariable long id) {
        Account currentAccount = this.accountService.getAccountByID(id);
        List<AccountRole> role = accountRoleService.getAllRole();
        model.addAttribute("role", role);
        model.addAttribute("newAccount", currentAccount);
        return "layout/pt/account/update_account";
    }

    @PostMapping("/pt/update/account")
    public String setUpdateAccountByPT(Model model, @ModelAttribute("newAccount") Account currentAccount) {
        Account newAccount = this.accountService.getAccountByID(currentAccount.getAccount_id());
        if (newAccount != null) {
            String hashPassword = this.bCryptPasswordEncoder.encode(currentAccount.getPassword());
            newAccount.setPassword(hashPassword);
            newAccount.setRole(currentAccount.getRole());
            this.accountService.handleSaveAccount(newAccount);
        }
        return "redirect:/pt/account";
    }

    // member_role
    @GetMapping("/member/account")
    public String showAccountByMember(Model model) {
        String username = customUserDetailsService.getCurrentUsername();
        Account accounts = accountService.getAccountByUser(username);
        model.addAttribute("accounts", accounts);
        return "layout/member/account/show_account";
    }

    @GetMapping("/member/update/account/{id}")
    public String getUpdateUserByMember(Model model, @PathVariable long id) {
        Account currentAccount = this.accountService.getAccountByID(id);
        List<AccountRole> role = accountRoleService.getAllRole();
        model.addAttribute("role", role);
        model.addAttribute("newAccount", currentAccount);
        return "layout/member/account/update_account";
    }

    @PostMapping("/member/update/account")
    public String setUpdateAccountByMember(Model model, @ModelAttribute("newAccount") Account currentAccount) {
        Account newAccount = this.accountService.getAccountByID(currentAccount.getAccount_id());
        if (newAccount != null) {
            String hashPassword = this.bCryptPasswordEncoder.encode(currentAccount.getPassword());
            newAccount.setPassword(hashPassword);
            newAccount.setRole(currentAccount.getRole());
            this.accountService.handleSaveAccount(newAccount);
        }
        return "redirect:/member/account";
    }

    // employee_role
    @GetMapping("/employee/account")
    public String showAccountByEmployee(Model model) {
        String username = customUserDetailsService.getCurrentUsername();
        Account accounts = accountService.getAccountByUser(username);
        System.out.println(accounts);
        model.addAttribute("accounts", accounts);
        return "account/show_account";
    }

    @GetMapping("/employee/update/account/{id}")
    public String getUpdateUserByEmployee(Model model, @PathVariable long id) {
        Account currentAccount = this.accountService.getAccountByID(id);
        List<AccountRole> role = accountRoleService.getAllRole();
        model.addAttribute("role", role);
        model.addAttribute("newAccount", currentAccount);
        return "account/update_account";
    }

    @PostMapping("/employee/update/account")
    public String setUpdateAccountByEmployee(Model model, @ModelAttribute("newAccount") Account currentAccount) {
        Account newAccount = this.accountService.getAccountByID(currentAccount.getAccount_id());
        if (newAccount != null) {
            String hashPassword = this.bCryptPasswordEncoder.encode(currentAccount.getPassword());
            newAccount.setPassword(hashPassword);
            newAccount.setRole(currentAccount.getRole());
            this.accountService.handleSaveAccount(newAccount);
        }
        return "redirect:/employee/account";
    }
}
