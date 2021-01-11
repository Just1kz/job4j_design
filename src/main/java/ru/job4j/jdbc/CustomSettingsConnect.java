package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CustomSettingsConnect {
    private String url;
    private String login;
    private String password;
    private final Map<String, String> values = new HashMap<String, String>();

    public CustomSettingsConnect() {
        getSettingsFileProperties();
        for (Map.Entry<String, String> x : values.entrySet()) {
            if (x.getKey().equals("url")) {
                this.url = x.getValue();
            }
            if (x.getKey().equals("login")) {
                this.login = x.getValue();
            }
            if (x.getKey().equals("password")) {
                this.password = x.getValue();
            }
        }
    }

    public void getSettingsFileProperties() {
        try (BufferedReader read = new BufferedReader(new FileReader(".\\src\\main\\resources\\app.properties"))) {
            read.lines()
                    .filter(x -> x.length() != 0 && !x.startsWith("#"))
                    .map(line -> line.split("="))
                    .forEach(x -> values.put(x[0], x[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
