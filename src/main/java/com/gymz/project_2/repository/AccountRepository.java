package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymz.project_2.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account save(Account acc);

    Account findById(long id);

    void deleteById(long id);

    Account findByUser(String username);

}
