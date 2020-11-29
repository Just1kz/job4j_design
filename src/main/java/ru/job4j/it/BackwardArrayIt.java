package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point;
    private int count = 1;

    public BackwardArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (count == 1) {
            point = data.length - 1;
        }
        return point >= 0;
    }

    @Override
    public Integer next() {
        if (count == 1) {
            point = data.length - 1;
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        count++;
        return data[point--];
    }
}
