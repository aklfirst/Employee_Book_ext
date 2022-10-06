package com.example.employee_book_ext.controller.EmployeeController;

import com.example.employee_book_ext.domain.Employee;
import com.example.employee_book_ext.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees/")

public class EmployeeController {

    private final EmployeeService employeeService;

@GetMapping
    public String welcome () {return "<h1>Добро пожаловать!</h1>";}


    @GetMapping("/departments/all")
    public Collection<Employee> printAllEmployees() {
        return employeeService.printAllEmployees();
    }

    @GetMapping("/departments/all-d")
    public List<Employee> printByDepartment(
            @RequestParam("department") int department) {
        return employeeService.printByDepartment(department);
    }

    @GetMapping("/departments/min-salary")
    public Optional<Employee> minSalary(
            @RequestParam("department") int department) {
        return employeeService.minSalary(department);
    }

    @GetMapping("/departments/max-salary")
    public Optional<Employee> maxSalary(
            @RequestParam("department") int department) {
        return employeeService.maxSalary(department);
    }

    @GetMapping("/find")
    public Optional<Employee> findEmployee(
            @RequestParam("key") String key) {
        return employeeService.find(key);
    }

    @GetMapping("/remove")
    public Optional<Employee> removeEmployee(
            @RequestParam("key") String key) {
        return employeeService.remove(key);
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("key") String key,
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastName,
            @RequestParam("department") Integer department,
            @RequestParam("salary") Float salary
    ) {
        return employeeService.add(key,name, lastName,department,salary);
    }

}
