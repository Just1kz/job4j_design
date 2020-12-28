package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

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

    @Test
    public void TemporaryFolderTest() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        Analizy analizy = new Analizy();
        List<String> input = new ArrayList<>();
        List<String> output = new ArrayList<>(List.of("10:57:01; 10:59:01", "11:01:02; 11:02:02"));

        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }

        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            read.lines()
                    .forEach(input::add);
        }

        assertThat(input, is(output));
    }
}