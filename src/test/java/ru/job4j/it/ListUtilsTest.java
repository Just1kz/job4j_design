package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(2, 1, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 0, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, -1 , 0, -2 , 3 , 5, -5));
        ListUtils.removeIf(input, x -> x < 0);
        assertThat(Arrays.asList(1, 3, 0, 3, 5), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, -1 , 0, -2 , 3 , 5, -5));
        ListUtils.replaceIf(input, x -> x < 0, 5);
        assertThat(Arrays.asList(1, 3, 5, 0, 5, 3, 5, 5), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input1 = new ArrayList<>(Arrays.asList(1, 3, -1 , 0, -2 , 3 , 5, -5));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(1, 0, 3));
        ListUtils.removeAll(input1, input2);
        assertThat(Arrays.asList(-1, -2, 5, -5), Is.is(input1));
    }
}