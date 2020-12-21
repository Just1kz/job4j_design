package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void diff() {
        Analize.User  u1 = new Analize.User(1, "A");
        Analize.User  u2 = new Analize.User(2, "B");
        Analize.User  u3 = new Analize.User(3, "C");
        Analize.User  u4 = new Analize.User(4, "D");
        Analize.User  u5 = new Analize.User(1, "Z");
        Analize.User  u6 = new Analize.User(8, "A");
        List<Analize.User> list1 = List.of(u1, u2, u3, u4);
        List<Analize.User> list2 = List.of(u5, u2, u6);
        Analize.Info info = new Analize.Info(1, 1, 2);
        Analize analize = new Analize();
        assertThat(analize.diffArray(list1, list2), is(info));
    }
}