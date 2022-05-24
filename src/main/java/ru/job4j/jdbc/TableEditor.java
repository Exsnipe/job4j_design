package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.ResultSet;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private final Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
    }

    private void initConnection() throws IOException, ClassNotFoundException, SQLException {
        try {
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("login"), properties.getProperty("password"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createTable(String tableName) throws Exception {
        initConnection();
        try (Statement statement = connection.createStatement()) {
            String sql = "create table if not exists " + tableName + " ()";
            statement.execute(sql);
        }
        close();
    }

    public void dropTable(String tableName) throws Exception {
        initConnection();
        try (Statement statement = connection.createStatement()) {
            String sql = "drop table " + tableName;
            statement.execute(sql);
        }
        close();
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        initConnection();
        try (Statement statement = connection.createStatement()) {
            String sql = "alter table " + tableName
                    + " add column " + columnName + " " + type;
            statement.execute(sql);
        }
        close();
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        initConnection();
        try (Statement statement = connection.createStatement()) {
            String sql = "alter table " + tableName
                    + " drop column " + columnName;
            statement.execute(sql);
        }
        close();
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        initConnection();
        try (Statement statement = connection.createStatement()) {
            String sql = "alter table " + tableName
                    + " rename column " + columnName + " to " + newColumnName;
            statement.execute(sql);
        }
        close();
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("configDB.properties"));
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable("ex1");
        Class.forName(properties.getProperty("driver"));
        Connection connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("login"), properties.getProperty("password"));
        tableEditor.addColumn("ex1", "num", "int");
        System.out.println(getTableScheme(connection, "ex1"));
        tableEditor.renameColumn("ex1", "num", "mun");
        System.out.println(getTableScheme(connection, "ex1"));
        tableEditor.dropColumn("ex1", "mun");
        System.out.println(getTableScheme(connection, "ex1"));
        tableEditor.dropTable("ex1");
    }
}
