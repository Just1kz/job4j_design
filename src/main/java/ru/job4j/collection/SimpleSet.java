package ru.job4j.collection;

public class SimpleSet<T> {
    private final SimpleArray<T> rsl = new SimpleArray<T>();

    public void add(T value) {
        boolean s = true;
        if(rsl.getLengthArray() != 0) {
            while (rsl.iterator().hasNext()) {
                if (rsl.iterator().next() == value) {
                    s = false;
                    break;
                }
            }
        }
        if (s) {
            rsl.add(value);
        }
    }
}
