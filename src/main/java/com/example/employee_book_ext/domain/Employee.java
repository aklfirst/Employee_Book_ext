package com.example.employee_book_ext.domain;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    private final int department;
    private final float salary;


    public Employee(String firstName, String lastName, int department, float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        }

    public int getDepartment() {
        return department;
    }
    public float getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public String getShortName() {
        return getFirstName().charAt(0) + "_" + getLastName();
    }


    @Override
    public String toString() {

        String c = " / ";
        String cWith = c.repeat(2);
               return "Сотрудник - " + "Имя: " + firstName + ", Фамилия: " + lastName + cWith;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getFirstName().equals(employee.getFirstName()) && getLastName().equals(employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }
}
