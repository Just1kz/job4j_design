package ru.job4j.concurrent;

public class ConcurrentOutput {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        Thread second = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        Thread third = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        Thread forth = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        Thread fifth = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        first.start();
        second.start();
        third.start();
        forth.start();
        fifth.start();
        System.out.println(Thread.currentThread().getName());
    }
}
