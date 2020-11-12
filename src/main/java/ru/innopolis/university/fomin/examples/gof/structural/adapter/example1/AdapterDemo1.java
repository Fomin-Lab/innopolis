package ru.innopolis.university.fomin.examples.gof.structural.adapter.example1;

import java.util.List;

public class AdapterDemo1 {
    public static void main(String[] args) {
        EmployeeClient client = new EmployeeClient();
        List<Employee> employees = client.getEmployeeList();

        for (Employee e : employees) {
            System.out.println("(" + e.getId() + ") " + e.getFirstName() + " " + e.getLastName());
            System.out.println("Email " + e.getEmail());
        }
    }
}
