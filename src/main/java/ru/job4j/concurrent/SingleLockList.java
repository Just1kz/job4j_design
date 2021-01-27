package ru.job4j.concurrent;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.collection.SimpleArray;

import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    @GuardedBy("this")
    private SimpleArray<T> rsl;

    public SingleLockList(SimpleArray<T> rsl) {
        this.rsl = rsl;
    }

    public synchronized void add(T value) {
        rsl.add(value);
    }

    public synchronized T get(int index) {
        return rsl.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return copy().iterator();
    }

    private synchronized SimpleArray<T> copy() {
        SimpleArray<T> result = new SimpleArray<>();
        for (T value : rsl) {
            result.add(value);
        }
        return result;
    }

}
