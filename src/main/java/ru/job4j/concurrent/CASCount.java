package ru.job4j.concurrent;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount<T> {
    private final AtomicReference<Integer> count = new AtomicReference<>();

    public void increment() {
        Integer count;
        do {
            count = this.count.get();
        } while (!this.count.compareAndSet(count, count + 1));
    }

    public int get() {
        return count.get();
    }

    //1. Реализовать неблокирующий счетчик.
}
