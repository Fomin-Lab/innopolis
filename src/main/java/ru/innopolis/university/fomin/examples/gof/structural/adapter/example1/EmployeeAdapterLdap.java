package ru.innopolis.university.fomin.examples.gof.structural.adapter.example1;

public class EmployeeAdapterLdap implements Employee {
    protected EmployeeLdap original;

    public EmployeeAdapterLdap(EmployeeLdap original) {
        this.original = original;
    }

    @Override
    public String getId() {
        return original.getCn();
    }

    @Override
    public String getFirstName() {
        return original.getGivenName();
    }

    @Override
    public String getLastName() {
        return original.getSurname();
    }

    @Override
    public String getEmail() {
        return original.getMail();
    }

    @Override
    public String toString() {
        return "EmployeeAdapterLdap{" +
                "id='" + original.getCn() + '\'' +
                ", firstName='" + original.getGivenName() + '\'' +
                ", lastName='" + original.getSurname() + '\'' +
                ", email='" + original.getMail() + '\'' +
                '}';
    }
}
