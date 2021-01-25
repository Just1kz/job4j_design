package ru.job4j.concurrent;

public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> { }
        );
        Thread second = new Thread(
                () -> { }
        );
        System.out.println(first.getState());
        first.start();
        second.start();
        int x = 1;
        while (first.getState() != Thread.State.TERMINATED
                || second.getState() != Thread.State.TERMINATED) {
            System.out.println(first.getState());
            System.out.println(second.getState());
            x++;
        }
        System.out.println(x);
        System.out.println(first.getState());
        System.out.println(second.getState());
        System.out.println("Work has been completed");
    }
}
