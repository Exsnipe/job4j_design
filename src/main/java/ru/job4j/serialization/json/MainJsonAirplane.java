package ru.job4j.serialization.json;

import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainJsonAirplane {
    public static void main(String[] args) {
        Airplane airplane = new Airplane("an-2", 4000,
                false, new Crew(2), new int[] {2, 7, 9, 4});
        JSONObject jsonObject =  new JSONObject();
        jsonObject.put("type", airplane.getType());
        jsonObject.put("weight", airplane.getWeight());
        jsonObject.put("isReactive", airplane.isReactive());
        jsonObject.put("crew", airplane.getCrew());
        jsonObject.put("cycles", airplane.getCycle());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(airplane));


    }

}
