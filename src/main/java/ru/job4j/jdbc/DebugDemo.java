package ru.job4j.jdbc;

import java.util.List;

import java.sql.*;
import java.util.ArrayList;

public class DebugDemo {
    private Connection connection;

    public DebugDemo() throws Exception {
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String userName = "postgres";
        String password = "password";
        connection = DriverManager.getConnection(url, userName, password);
    }

    public void createTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute(
                    "create table if not exists cities(id serial primary key,"
                            + "name text, population int);"
            );
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public City insertCity(City city) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into cities (name, population) values(?,?);",
                Statement.RETURN_GENERATED_KEYS
        )) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getPopulation());
            preparedStatement.execute();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return city;
    }

    public List<City> getAll() {
        List<City> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from cities;");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                result.add(new City(
                   resultSet.getInt("id"),
                   resultSet.getString("name"),
                   resultSet.getInt("population")
                ));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        City first = new City("CityOne", 100);
        City second = new City("CityTwo", 200);
        DebugDemo debugDemo = new DebugDemo();
        debugDemo.initConnection();
        debugDemo.createTable();
        debugDemo.insertCity(first);
        debugDemo.insertCity(second);
        for (City city : debugDemo.getAll()) {
            System.out.println(city);
        }

    }
}
