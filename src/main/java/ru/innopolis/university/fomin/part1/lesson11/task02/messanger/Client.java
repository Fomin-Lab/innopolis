package ru.innopolis.university.fomin.part1.lesson11.task02.messanger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class Client
 * Use client socket
 * Class performs the task conditions lesson11.task02
 *
 * For create more then one client set "Allow parallel run" option on run/debug configurations settings
 */
@SuppressWarnings("Duplicates")
public class Client {
    /**
     * log4j logger
     */
    protected static final Logger logger = LogManager.getLogger(Client.class);

    /**
     * Port to connect socket
     */
    protected static int CONNECT_PORT = 20323;

    /**
     * Entry point
     * Use for start client
     *
     * @param args
     *        Input arguments
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    public static void main(String[] args) throws IOException {
        runClient();
    }

    /**
     * Start client socket and send messages
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    private static void runClient() throws IOException {
        Socket socket = new Socket("localhost", CONNECT_PORT);

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
            System.out.println("Введите ваше имя и отправьте сообщение.");

            // Слушаем входящие сообщения
            Thread listenIncomingMessages = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        System.out.println("Входящее сообщение: " + reader.readLine());
                    } catch (IOException e) {
                        logger.error(e);
                        Thread.currentThread().interrupt();
                    }
                }
            });

            listenIncomingMessages.start();

            // Отправляем сообщения
            while (true) {
                String line = console.nextLine();
                out.println(line);
                if ("exit".equals(line)) {
                    socket.close();
                    listenIncomingMessages.interrupt();
                    break;
                }
            }
        }
    }
}
