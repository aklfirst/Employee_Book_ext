package com.example.employee_book_ext.service;

import com.example.employee_book_ext.domain.Employee;
import com.example.employee_book_ext.exceptions.EmployeeAlreadyAddedException;
import com.example.employee_book_ext.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {


    public Map<String, Employee> employees = new HashMap<>(Map.of(
           "A_Клепов", new Employee("Александр", "Клепов", 5, 200_000),
            "Д_Фролов", new Employee("Дмитрий", "Фролов",  2, 250_000),
            "Д_Волосевич", new Employee("Дмитрий", "Волосевич", 5, 50_000),
            "А_Карпов", new Employee("Анатолий", "Карпов",  3, 60_000),
            "Г_Каспаров", new Employee("Гарии", "Каспаров", 1, 90_000),
            "А_Елькин", new Employee("Андрей", "Елькин", 1, 190_000),
            "В_Палкин", new Employee("Василий", "Палкин", 2, 110_000),
            "И_Иванов", new Employee("Иван1", "Иванов",  2, 120_000),
            "И_ВторойИванов", new Employee("Иван2", "ВторойИванов", 2, 125_000),
            "И_ТретийИванов", new Employee("Иван3", "ТретийИванов",  3, 130_000)
    ));

    @Override
    public List<Employee> printAllEmployees() {
        return employees.values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }


    @Override
    public List <Employee> printByDepartment(int department) {
        return employees.values().stream()
                .filter(e->e.getDepartment() == (department))
                .collect(Collectors.toList());
        }


    @Override
    public Optional<Employee> remove(String key) throws EmployeeNotFoundException {
        Optional<Employee> forRemove = find(key);
        employees.remove(key);
        return forRemove;
    }


    @Override
    public Employee add(String key, String firstName, String lastName, int department, float salary) throws EmployeeAlreadyAddedException {
        Employee employeeToAdd = new Employee(firstName,lastName,department,salary);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в базе!");
        }
        employees.put(key,employeeToAdd);
        return employeeToAdd;
    }


    @Override
    public Optional<Employee> find(String key) {
        return Optional.ofNullable(employees.values().stream()
                .filter(e -> e.getShortName().equals(key))
                .findAny()
                .orElseThrow(() -> new EmployeeNotFoundException("Такой сотрудник не найдем!")));
    }

    public Optional<Employee> minSalary(int department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment() == (department))
                .min(Comparator.comparingDouble(Employee::getSalary));
    }

    public Optional<Employee> maxSalary(int department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment() == (department))
                .max(Comparator.comparingDouble(Employee::getSalary));
    }

}



