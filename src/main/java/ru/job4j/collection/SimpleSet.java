package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private final SimpleArray<T> rsl = new SimpleArray<T>();

    public void add(T value) {
        if (!contains(value)) {
            rsl.add(value);
        }
    }

    public boolean contains(T value) {
        if (rsl.getLengthArray() != 0) {
            for (T xxx : rsl) {
                if (Objects.equals(xxx, value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return rsl.iterator();
    }
}
