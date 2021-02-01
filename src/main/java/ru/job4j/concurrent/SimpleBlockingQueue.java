package ru.job4j.concurrent;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("monitor")
    private Queue<T> queue = new LinkedList<>();

    private final Object monitor = this;

    private final int bound;

    public SimpleBlockingQueue(int bound) {
        this.bound = bound;
    }

    public void offer(T value) {
        synchronized (monitor) {
            try {
                while (queue.size() == bound) {
                    System.out.println(Thread.currentThread().getName());
                    wait();
                }
                queue.add(value);
                notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public T poll() {
        synchronized (monitor) {
            T result = null;
            try {
                while (queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName());
                    wait();
                }
                result = queue.poll();
                notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return result;
        }
    }

    public synchronized int size() {
        return queue.size();
    }
}