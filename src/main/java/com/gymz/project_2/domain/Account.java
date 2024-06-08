package com.gymz.project_2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Account {
    @Id
    @Column(length = 6, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long account_id;

    @Column(length = 30, nullable = false, unique = true)
    private String user;

    @Column(length = 30, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 6, nullable = false)
    private AccountType accountType;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name = "pt_id")
    private Pt pt;

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Pt getPt() {
        return pt;
    }

    public void setPt(Pt pt) {
        this.pt = pt;
    }

    @Override
    public String toString() {
        return "Account [account_id=" + account_id + ", user=" + user + ", password=" + password + ", accountType="
                + accountType + ", employee=" + employee + ", member=" + member + ", pt=" + pt + "]";
    }

}
