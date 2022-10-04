package com.example.employee_book_ext.service;

import com.example.employee_book_ext.domain.Employee;

import java.util.Collection;

public interface EmployeeService {

    Collection<Employee> printAllEmployees();

    public Employee find(String firstName, String lastName);
    public Employee add(String firstName, String lastName);

    public Employee remove(String firstName, String lastName);


}