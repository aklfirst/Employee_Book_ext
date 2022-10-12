package com.example.employee_book_ext.service;

import com.example.employee_book_ext.domain.Employee;
import com.example.employee_book_ext.exceptions.EmployeeAlreadyAddedException;
import com.example.employee_book_ext.exceptions.EmployeeNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> printAllEmployees();

    public List<Employee> printByDepartment(int department);

    public Optional<Employee> remove(String key) throws EmployeeNotFoundException;

    public Employee add(String key, String firstName, String lastName, int department, float salary) throws EmployeeAlreadyAddedException;
    public Optional<Employee> find(String key) throws EmployeeNotFoundException;

    public Optional<Employee> minSalary (int department);

    public Optional<Employee> maxSalary (int department);
}