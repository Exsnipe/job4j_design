package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            String firstLine;
            while (!server.isClosed()) {
                List<String> message = new ArrayList<>();
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream()) {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    firstLine = in.readLine();
                    String[] answer = firstLine.split(" ");
                    String msgAnswer = "";
                    if ("/?msg=Bye".equals(answer[1])) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Завершить работу сервера".getBytes());
                        server.close();
                        continue;
                    }
                    if ("/?msg=Hello".equals(answer[1])) {
                        msgAnswer = "Hello";
                    } else {
                        msgAnswer = "What";
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(msgAnswer.getBytes());
                    System.out.println(firstLine);
                    out.flush();
                }
            }
        }
    }
}
