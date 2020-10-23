package ru.innopolis.university.fomin.examples.net;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Старт подключения");

        Socket socket = new Socket("localhost", 25555);

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()
                ));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(
                             socket.getOutputStream()
                     ), true
            );
             Scanner console = new Scanner(System.in);
        ) {

            while (true) {
                String line = console.nextLine();
                if ("end".equals(line)) {
                    break;
                }
                out.println(line);
                System.out.println("Ответ от сервера " + reader.readLine());
            }

        }
    }
}
