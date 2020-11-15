package ru.innopolis.university.fomin.examples.gof.behavioral.memento.example1;

import java.util.Stack;

public class Caretaker {
    private Stack<EmployeeMemento> employeeHistory = new Stack<>();

    public void save(Employee emp) {
        employeeHistory.push(emp.save());
    }

    public void revert(Employee emp) {
        emp.revert(employeeHistory.pop());
    }
}
