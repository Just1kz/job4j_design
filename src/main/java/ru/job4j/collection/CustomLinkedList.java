package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements Iterable<T> {
    private Node<T> first = null;
    private Node<T> last = null;
    private int modCount = 0;
    public int sizeList = 0;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        sizeList++;
        modCount++;
    }

    public T get(int index) {
        Node<T> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> lastReturned = first;
            private Node<T> nodeInMemory = null;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkModCount();
                return lastReturned != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = lastReturned.data;
                Node<T> temp = nodeInMemory;
                nodeInMemory = lastReturned;
                lastReturned = lastReturned.next;
                return result;
            }
            private void checkModCount() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
