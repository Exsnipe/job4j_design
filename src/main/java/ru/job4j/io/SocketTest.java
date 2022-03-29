package ru.job4j.io;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9001);

        serverSocket.accept();
    }
}
