package com.gymz.project_2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.AccountRole;
import com.gymz.project_2.repository.AccountRoleRepository;

@Service
public class AccountRoleService {
    public final AccountRoleRepository accountRoleRepository;

    public AccountRoleService(AccountRoleRepository accountRoleRepository) {
        this.accountRoleRepository = accountRoleRepository;
    }

    public void handleSaveRole(AccountRole role) {
        this.accountRoleRepository.save(role);
    }

    public List<AccountRole> getAllRole() {
        return this.accountRoleRepository.findAll();
    }
}
