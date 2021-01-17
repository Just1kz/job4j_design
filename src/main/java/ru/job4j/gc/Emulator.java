package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Emulator {
    private final CustomCash cash;

    public Emulator(CustomCash cash) {
        this.cash = cash;
    }

    private static final String LN = System.lineSeparator();

    public String getText(String name, List<File> fileList) {
        String result = "";
        if (fileList.contains(new File(name))) {
            if (cash.get(name) == null) {
                cash.add(name, readFile(name));
            }
            result = Objects.requireNonNull(cash.get(name).get()).toString();
        }
        return result;
    }

    private String readFile(String fileName) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                result.append(String.format("%s%s", line, LN));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
