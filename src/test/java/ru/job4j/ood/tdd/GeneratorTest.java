package ru.job4j.ood.tdd;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

public class GeneratorTest {

    @Test
    @Ignore
    public void whenTemplateComplete() {
        Generator generator = new CustomGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "Anton",
                "subject", "you"
        );
        String out = generator.produce(template, map);
        Assert.assertThat(
                out,
                Is.is("I am a Ivan, Who are you?")
        );
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenNotEnough() {
        Generator generator = new CustomGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "Anton"
        );
        String out = generator.produce(template, map);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenExtraArgs() {
        Generator generator = new CustomGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "Anton",
                "subject", "you",
                "something", "something"
        );
        String out = generator.produce(template, map);
    }
}