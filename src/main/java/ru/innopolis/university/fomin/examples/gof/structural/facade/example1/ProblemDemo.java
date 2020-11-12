package ru.innopolis.university.fomin.examples.gof.structural.facade.example1;

import java.sql.*;

public class ProblemDemo {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:db");

            Statement sta = conn.createStatement();
            sta.executeUpdate("CREATE TABLE Address (ID INTEGER, StreetName VARCHAR (20), " +
                    "City VARCHAR(20))");
            int count;

            System.out.println("Table created.");
            sta.close();

            sta = conn.createStatement();
            count = sta.executeUpdate("INSERT INTO Address (ID, StreetName, City) " +
                    "values (1, '1234 Some street', 'Layton')");
            System.out.println(count + " record(s) created.");
            sta.close();

            sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Address");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
