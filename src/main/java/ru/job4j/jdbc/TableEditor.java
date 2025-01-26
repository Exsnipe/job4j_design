package ru.job4j.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;
import java.io.InputStream;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private final Properties properties;

    public TableEditor(Properties properties)
            throws SQLException, IOException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("login"), properties.getProperty("password"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createStatement(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        String sql = "create table if not exists " + tableName + " ()";
        createStatement(sql);
    }

    public void dropTable(String tableName) {
        String sql = "drop table " + tableName;
        createStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = "alter table " + tableName
                + " add column " + columnName + " " + type;
        createStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = "alter table " + tableName
            + " drop column " + columnName;
        createStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = "alter table " + tableName
            + " rename column " + columnName + " to " + newColumnName;
        createStatement(sql);
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
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader()
                .getResourceAsStream("configDB.properties")) {
            config.load(in);
        }
        try (TableEditor tableEditor = new TableEditor(config);) {
            tableEditor.createTable("ex1");
            Class.forName(config.getProperty("driver"));
            Connection connection = DriverManager.getConnection(config.getProperty("url"),
                    config.getProperty("login"), config.getProperty("password"));
            tableEditor.addColumn("ex1", "num", "int");
            System.out.println(getTableScheme(connection, "ex1"));
            tableEditor.renameColumn("ex1", "num", "mun");
            System.out.println(getTableScheme(connection, "ex1"));
            tableEditor.dropColumn("ex1", "mun");
            System.out.println(getTableScheme(connection, "ex1"));
            tableEditor.dropTable("ex1");
        }
    }
}
