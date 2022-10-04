package com.example.employee_book_ext.controller.EmployeeController;

import com.example.employee_book_ext.domain.Employee;
import com.example.employee_book_ext.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees/")

public class EmployeeController {

    private final EmployeeService employeeService;

@GetMapping
    public String welcome () {return "<h1>Добро пожаловать!</h1>";}


    @GetMapping("/printAll")
    public Collection<Employee> printAllEmployees() {
        return employeeService.printAllEmployees();
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastName
    ) {
        return employeeService.find(name, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastName
    ) {
        return employeeService.remove(name, lastName);
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastName
    ) {
        return employeeService.add(name, lastName);
    }

}
