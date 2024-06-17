package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymz.project_2.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee save(Employee employee);

    Employee findById(long id);

    void deleteById(long id);
}
