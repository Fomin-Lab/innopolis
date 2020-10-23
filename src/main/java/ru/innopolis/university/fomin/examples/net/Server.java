package ru.innopolis.university.fomin.examples.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // Определяем порт, который будем слушать
        ServerSocket serverSocket = new ServerSocket(25555); // Открыли сокет

        while (true) {

            // Ждём подключение клиента и открываем IO-потоки
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader reader = new BufferedReader(
                         new InputStreamReader(
                                 socket.getInputStream()
                         )
                 )
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Получено от клиента: " + line);
                    out.println("Echo: " + line);
                }
            }
        }
    }
}
