package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CustomSettingsConnect {
    private final String url;
    private final String login;
    private final String password;
    private final Map<String, String> values = new HashMap<String, String>();

    public CustomSettingsConnect() {
        getSettingsFileProperties();
                this.url = values.get("url");
                this.login = values.get("login");
                this.password = values.get("password");
        if (url == null
                || login == null
                || password == null) {
            throw new IllegalArgumentException("You set not all parameters in file app.properties."
            + " Check your file.");
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
