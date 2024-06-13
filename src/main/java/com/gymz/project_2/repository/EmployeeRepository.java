package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymz.project_2.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee save(Employee employee);

}
