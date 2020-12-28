package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Test
    public void unavailable() {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "unavailable.csv");
        List<String> input = new ArrayList<>();
        List<String> output = new ArrayList<>(List.of("10:57:01; 10:59:01", "11:01:02; 11:02:02"));
        try (BufferedReader read = new BufferedReader(new FileReader("unavailable.csv"))) {
            read.lines().forEach(input::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(input, is(output));
    }
}