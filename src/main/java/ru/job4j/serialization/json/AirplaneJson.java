package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AirplaneJson {
    public static void main(String[] args) {
        final Airplane an2 = new Airplane("An-2", 4000, false,
                new Crew(2), new int[] {6, 8, 2, 9});

        Gson gson = new GsonBuilder().create();
        String gsonString = gson.toJson(an2);
        System.out.println(gsonString);
        Airplane airplaneMode = gson.fromJson(gsonString, Airplane.class);
        System.out.println(airplaneMode);
    }
}
