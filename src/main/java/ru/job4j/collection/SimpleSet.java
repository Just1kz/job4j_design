package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private final SimpleArray<T> rsl = new SimpleArray<T>();

    public void add(T value) {
        if (contains(value)) {
            rsl.add(value);
        }
    }

    public boolean contains(T value) {
        boolean s = true;
        if (rsl.getLengthArray() != 0) {
            while (rsl.iterator().hasNext()) {
                if (rsl.iterator().next().equals(value)) {
                    s = false;
                    break;
                }
            }
        }
        return s;
    }

    @Override
    public Iterator<T> iterator() {
        return rsl.iterator();
    }
}
