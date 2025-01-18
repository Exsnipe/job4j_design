package ru.job4j.jdbc;

public class SF {
    public static void main(String[] args) {
        String tableName = "demo_table";
        String sql = String.format(
                "create table if not exists " + tableName + "(%s, %s)",
                "id serial primary key",
                "name text"
        );
        System.out.println(sql);
    }
}
