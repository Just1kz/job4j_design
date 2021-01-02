package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        final Student student = new Student(true, 2, new TrainingPlatform("Job4j"), "SE", "EE");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        final Gson gson2 = new GsonBuilder().create();
        System.out.println(gson.toJson(person));
        System.out.println(gson2.toJson(student));

        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final String studentJson = "{"
                +"\"learn\":true,"
                + "\"lastCourse\":2,"
                + "\"trainingPlatform\":"
                + "{"
                + "\"name\":\"Job4j\""
                + "},"
                + "\"directions\":"
                + "[\"SE\",\"EE\"]"
                + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        final Student studentMod = gson2.fromJson(studentJson, Student.class);
        System.out.println(personMod);
        System.out.println(studentMod);
    }

}
