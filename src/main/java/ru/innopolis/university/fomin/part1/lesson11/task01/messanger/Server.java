package ru.innopolis.university.fomin.part1.lesson11.task01.messanger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Class Server
 * Use server socket
 * Class performs the task conditions lesson11.task01
 */
@SuppressWarnings("Duplicates")
public class Server {
    /**
     * log4j logger
     */
    protected static final Logger logger = LogManager.getLogger(Server.class);

    /**
     * Map of all connected users
     */
    protected static final Map<String, Socket> users = new HashMap<>();

    /**
     * if listen client connections
     */
    protected static boolean isListening = true;

    /**
     * Listen port
     */
    protected static int LISTEN_PORT = 20323;

    /**
     * Entry point
     * Use for start server
     *
     * @param args
     *        Input arguments
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    public static void main(String[] args) throws IOException {
        runServer();
    }

    /**
     * Start server socket and listen incoming messages
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    private static void runServer() throws IOException {
        logger.info("Server start");

        ServerSocket serverSocket = new ServerSocket(LISTEN_PORT);

        while (isListening) {
            Socket socket = serverSocket.accept();

            new Thread(() -> {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                } catch (IOException e) {
                    Thread.currentThread().interrupt();
                    logger.error(e);
                }

                // Ожидаем ввод имени от клиента
                String userName = null;
                try {
                    assert reader != null;
                    userName = reader.readLine();
                } catch (IOException e) {
                    Thread.currentThread().interrupt();
                    logger.error(e);
                }

                logger.info("Подключился - " + userName);

                // Сохраняем подключение в колекцию
                synchronized (users) {
                    users.put(userName, socket);
                }

                // Слушаем сообщения от клиента
                while (socket.isConnected()) {
                    try {
                        String line = reader.readLine();
                        if (line == null) continue;
                        logger.info(userName + " отправил: " + line);
                        sendBroadCast(userName, line);
                    } catch (IOException e) {
                        Thread.currentThread().interrupt();
                        logger.error(e);
                        break;
                    }
                }
            }).start();
        }
    }

    /**
     * Send message to all connected users
     *
     * @param user
     *        Username is sender message
     *
     * @param message
     *        Message for broadcast send
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    private static void sendBroadCast(String user, String message) throws IOException {
        for (Map.Entry<String, Socket> entry : users.entrySet()) {
            // Самому себе не отправляем
            if (!user.equals(entry.getKey())) {
                Socket clientSocket = entry.getValue();
                if (clientSocket.isConnected()) {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println(user + " отправил вам сообщение: " + message);
                }
            }
        }
    }
}
