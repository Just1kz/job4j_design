package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "C:\\Users\\Just1lz\\IdeaProjects\\job4j_design\\src\\main\\resources\\app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Anton")
        );
    }
}