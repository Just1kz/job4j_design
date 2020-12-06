package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int sizeArray = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public int getLengthArray() {
        return sizeArray;
    }

    public void add(T model) {
        Objects.checkIndex(sizeArray, array.length);
        array[sizeArray++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, sizeArray);
        array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, sizeArray);
        sizeArray--;
        System.arraycopy(array, index + 1, array,
                index, sizeArray - index);
        array[sizeArray] = null;
    }
    public T get(int index) {
        Objects.checkIndex(index, sizeArray);
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                return count < sizeArray;
            }

            @Override
            public T next() {
                return (T) array[count++];
            }
        };
    }
}