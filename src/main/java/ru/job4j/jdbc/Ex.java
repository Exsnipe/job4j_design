package ru.job4j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://127.0.0.1:5432/spammer";
        String login = "postgres";
        String password = "password";
        Connection connection = DriverManager.getConnection(url, login, password);
        connection.close();
    }
}
