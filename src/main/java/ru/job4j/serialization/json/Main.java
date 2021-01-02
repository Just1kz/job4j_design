package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
//        final Student student = new Student(true, 2, new TrainingPlatform("Job4j"), "SE", "EE");
//
//        /* Преобразуем объект person в json-строку. */
//        final Gson gson = new GsonBuilder().create();
//        final Gson gson2 = new GsonBuilder().create();
//        System.out.println(gson.toJson(person));
//        System.out.println(gson2.toJson(student));
//
//        /* Модифицируем json-строку */
//        final String personJson =
//                "{"
//                        + "\"sex\":false,"
//                        + "\"age\":35,"
//                        + "\"contact\":"
//                        + "{"
//                        + "\"phone\":\"+7(924)111-111-11-11\""
//                        + "},"
//                        + "\"statuses\":"
//                        + "[\"Student\",\"Free\"]"
//                        + "}";
//        final String studentJson = "{"
//                +"\"learn\":true,"
//                + "\"lastCourse\":2,"
//                + "\"trainingPlatform\":"
//                + "{"
//                + "\"name\":\"Job4j\""
//                + "},"
//                + "\"directions\":"
//                + "[\"SE\",\"EE\"]"
//                + "}";
//        final Person personMod = gson.fromJson(personJson, Person.class);
//        final Student studentMod = gson2.fromJson(studentJson, Student.class);
//        System.out.println(personMod);
//        System.out.println(studentMod);

        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");
        JSONObject jsonTrainingPlatform = new JSONObject("{\"name\":\"Job4j\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        list2.add("SE");
        list2.add("EE");
        JSONArray jsonStatuses = new JSONArray(list);
        JSONArray jsonDirections = new JSONArray(list2);

        /* JSONObject напрямую методом put */
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);
        final Student student = new Student(true, 2, new TrainingPlatform("Job4j"), "SE", "EE");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("learn", student.isLearn());
        jsonObject2.put("lastCourse", student.getLastCourse());
        jsonObject2.put("trainingPlatform", student.getTrainingPlatform().toString());
        jsonObject2.put("directions", jsonDirections);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject2.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(person).toString());
        System.out.println(new JSONObject(student).toString());
    }

}
