package ru.job4j.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {

    private final ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    private void emailTo(UserEmailNotification user) {
        pool.submit(() -> {
            String subject = String.format("subject = Notification {%s} to email {%s}", user.getName(), user.getEmail());
            String body = String.format("Add a new event to {%s}", user.getName());
            send(subject, body, user.getEmail());
        });
    }

    private void close() {
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void send(String subject, String body, String email) {
    }

}
