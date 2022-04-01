package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            String firstLine = "";
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream()) {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    firstLine = in.readLine();
                    String[] answer = firstLine.split(" ");
                    if ("/?msg=Exit".equals(answer[1])) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Завершить работу сервера".getBytes());
                        server.close();
                        continue;
                    }
                    if ("/?msg=Hello".equals(answer[1])) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Hello".getBytes());
                    } else {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("What".getBytes());
                    }
                    System.out.println(firstLine);
                    out.flush();
                }
            }
        } catch (Exception ex) {
            LOG.error("Exception", ex);
        }
    }
}
