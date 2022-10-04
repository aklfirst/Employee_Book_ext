package com.example.employee_book_ext.domain;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;



    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
