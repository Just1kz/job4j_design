package ru.job4j.gc;

import java.lang.instrument.Instrumentation;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Removed %d %s%n", age, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private static void info() {
        System.out.println("=== Memory state ===");
        final int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        System.out.printf("Total: %d%n", totalMemory / mb);
        System.out.printf("Free: %d%n", freeMemory / mb);
        System.out.printf("Used: %d%n", usedMemory / mb);
    }

    public static void main(String[] args) {
        info();
        System.out.println();
        for (int i = 0; i < 1000; i++) {
            new User();
            info();
            new User("N", i);
            info();
        }
        System.gc();
        info();
    }

}
