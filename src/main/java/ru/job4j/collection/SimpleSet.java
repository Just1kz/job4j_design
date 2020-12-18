package ru.job4j.collection;

public class SimpleSet<T> {
    private SimpleArray<T> rsl = new SimpleArray<T>();

    public void add(T value) {
        boolean s = true;
        while (rsl.iterator().hasNext()) {
            if (rsl.iterator().next() == value) {
                s = false;
                break;
            }
        }
        if (s) {
            rsl.add(value);
        }
    }
}
