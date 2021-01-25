package ru.job4j.concurrent;

public class Wget {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            System.out.println("Start loading ... ");
                            int index = 0;
                            for (int x = 0; x <= 100; x++) {
                                System.out.print("\rLoading : " + index + "%");
                                Thread.sleep(1000);
                                index++;
                            }
                            System.out.println("");
                            Thread.currentThread().getState();
                            System.out.println("Loaded.");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                    }
                }
        );
        System.out.println(thread.getState());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
        System.out.println(thread.getState());
    }
}
