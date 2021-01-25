package ru.job4j.concurrent;

public class Wget {
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    try {
                        System.out.println("Start loading ... ");
                        int index = 0;
                        for (int x = 0; x <= 100; x++) {
                            System.out.print("\rLoading : " + index  + "%");
                            Thread.sleep(1000);
                            index++;
                        }
                        System.out.println("");
                        Thread.currentThread().getState();
                        System.out.println("Loaded.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
    }
}
