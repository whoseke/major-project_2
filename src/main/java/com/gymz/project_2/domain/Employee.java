package com.gymz.project_2.domain;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
    @Id
    @Column(length = 6, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(length = 30, nullable = false)
    private String position;

    @Column(length = 10, nullable = false)
    private BigDecimal salary;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Shift> shifts;

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [employee_id=" + employee_id + ", name=" + name + ", position=" + position + ", salary="
                + salary + "]";
    }

}
