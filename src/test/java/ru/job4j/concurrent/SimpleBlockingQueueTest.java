package ru.job4j.concurrent;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {
    SimpleBlockingQueue queue = new SimpleBlockingQueue(5);

    @Test
    public void offer() throws InterruptedException {
        Thread producer = new Thread(() -> queue.offer(3));
        producer.start();
        producer.join();
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void poll() throws InterruptedException {
        Thread producer = new Thread(() -> queue.offer(3));
        Thread consumer = new Thread(() -> queue.poll());
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        Assert.assertEquals(0, queue.size());
    }
}