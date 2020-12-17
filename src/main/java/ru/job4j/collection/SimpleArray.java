package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container;
    private int sizeArray = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.container = new Object[10];
        modCount++;
    }

    public int getLengthArray() {
        return sizeArray;
    }

    public void add(T model) {
        Objects.checkIndex(sizeArray, container.length);
        if (sizeArray == container.length - 1) {
            container = Arrays.copyOf(container, sizeArray * 2);
        }
        container[sizeArray++] = model;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, sizeArray);
        modCount++;
        return (T) container[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final int expectedModCount = modCount;
            private int count = 0;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < sizeArray;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[count++];
            }
        };
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + "container="
                + Arrays.toString(container)
                + '}';
    }
}
