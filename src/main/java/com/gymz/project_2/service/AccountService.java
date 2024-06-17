package com.gymz.project_2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.Account;
import com.gymz.project_2.repository.AccountRepository;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account handleSaveAccount(Account acc) {
        return this.accountRepository.save(acc);
    }

    public List<Account> getAllAccount() {
        return this.accountRepository.findAll();
    }

    public Account getAccountByID(long id) {
        return this.accountRepository.findById(id);
    }

    public void deleteAccountById(long id) {
        this.accountRepository.deleteById(id);
    }
}
