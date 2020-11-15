package ru.innopolis.university.fomin.examples.gof.behavioral.memento.example1;

import java.io.*;

public class MementoEverydayDemo {
    public static void main(String[] args) {
        EverydayEmployee emp = new EverydayEmployee();
        emp.setName("Bryan Hansen");
        emp.setAddress("111 E Code Street");
        emp.setPhone("123-123-1231");

        serializable(emp);

        EverydayEmployee newEmp = deserialize();
        System.out.println(newEmp.getName());
    }

    private static void serializable(EverydayEmployee emp) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static EverydayEmployee deserialize() {
        EverydayEmployee emp = null;
        try {
            FileInputStream fileIn = new FileInputStream("./employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            emp = (EverydayEmployee) in.readObject();
            in.close();
            fileIn.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return emp;
    }

}
