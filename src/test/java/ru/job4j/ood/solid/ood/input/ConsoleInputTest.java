package ru.job4j.ood.solid.ood.input;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ConsoleInputTest {

    @Test
    public void splitAsk() {
        ConsoleInput input = new ConsoleInput();
        String[] output = {"да", "нет"};
        assertThat(input.splitAsk("да, нет", ", "), is(output));
    }
}