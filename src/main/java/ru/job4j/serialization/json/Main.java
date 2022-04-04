package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("58585"),
                new String[] {"Worker", "Married"});
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        final String personJson =
            "{"
            + "\"sex\":false,"
            + "\"age\":30,"
            + "\"contact\":"
                + "{"
                + "\"phone\":\"5855\""
                + "},"
            + "\"statuses\":"
                + "["
                + "\"Worker\","
                + "\"Married\""
                + "]"
            + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}
