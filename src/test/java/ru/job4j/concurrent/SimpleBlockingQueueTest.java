package ru.job4j.concurrent;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

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

    @Test
    public void whenFetchAllThenGetIt() throws InterruptedException {
        final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);
        Thread producer = new Thread(
                () -> {
                    IntStream.range(0, 5).forEach(
                            queue::offer
                    );
                }
        );
        producer.start();
        Thread consumer = new Thread(
                () -> {
                    try {
                        while (queue.size() > 0 || !Thread.currentThread().isInterrupted()) {
                            if (queue.size() > 0) {
                                buffer.add(queue.poll());
                            }
                        }
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
        );
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
        assertThat(buffer, Is.is(Arrays.asList(0, 1, 2, 3, 4)));
    }
}