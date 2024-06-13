package com.gymz.project_2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.Employee;
import com.gymz.project_2.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    public Employee handEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

}
