package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainJson {
    public static void main(String[] args) {
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");
        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonArray = new JSONArray(list);
        final Person person = new Person(false, 30, new Contact("577-68758"),
                new String[] {"Worker", "Marries"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses",  jsonArray);
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(person).toString());
    }
}
