package ru.job4j.concurrent;

import net.jcip.annotations.Immutable;

@Immutable
public class Node<T> {
    private Node next;
    private T value;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
