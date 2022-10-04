package com.example.employee_book_ext.service;

import com.example.employee_book_ext.domain.Employee;
import com.example.employee_book_ext.exceptions.EmployeeAlreadyAddedException;
import com.example.employee_book_ext.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Александр", "Клепов"),
            new Employee("Дмитрий", "Фролов"),
            new Employee("Дмитрий", "Волосевич"),
            new Employee("Анатолий", "Карпов"),
            new Employee("Иван1", "Иванов"),
            new Employee("Иван2", "ВторойИванов"),
            new Employee("Иван3", "ТретийИванов")
    ));

    @Override
    public Collection<Employee> printAllEmployees() {
      return Collections.unmodifiableList(employees);
    }

    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee forRemove = new Employee(firstName, lastName);
        if (!employees.contains(forRemove)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден!");
        }
        employees.remove(forRemove);
        return forRemove;
    }


    @Override
    public Employee add(String firstName, String lastName) throws EmployeeAlreadyAddedException {
        Employee toAdd = new Employee(firstName, lastName);
        if (employees.contains(toAdd)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в базе!");
        }
        employees.add(toAdd);
        return toAdd;
    }


    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                return employees.get(i);
            }
        }
        throw new EmployeeNotFoundException("Такой сотрудник не найдем!");
    }

}



