package ru.innopolis.university.fomin.examples.gof.structural.facade.example1;

import java.util.List;

public class FacadeDemo1 {
    public static void main(String[] args) {
        JdbcFacade jdbcFacade = new JdbcFacade();

        jdbcFacade.createTable();
        System.out.println("Table created.");

        jdbcFacade.insertIntoTable();
        System.out.println("Record(s) inserted.");

        List<Address> addresses = jdbcFacade.getAddresses();
        for (Address address : addresses) {
            System.out.println(address);
        }
    }
}
