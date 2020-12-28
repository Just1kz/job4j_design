package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        List<String> xrt = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(x -> x.length() != 0 && !x.startsWith("#"))
                    .map(line -> line.split("="))
                    .forEach(x -> values.put(x[0], x[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        if (!values.containsKey(key)) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        } else {
            return values.get(key);
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("C:\\Users\\Just1lz\\IdeaProjects\\job4j_design\\src\\main\\resources\\app.properties");
        config.load();
        System.out.println(config.values);
        System.out.println(config.value("name"));
    }
}
