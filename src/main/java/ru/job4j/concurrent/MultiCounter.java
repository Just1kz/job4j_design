package ru.job4j.concurrent;

public class MultiCounter {
    public static void main(String[] args) {
        CountBarrier countBarrier = new CountBarrier(10);
        Thread masterShifu = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    try {
                        while (countBarrier.getCount() != countBarrier.getTotal()) {
                            countBarrier.count();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                "MasterShifu"
        );
        Thread panda = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    countBarrier.await();
                    System.out.println("Блокировка c потока - " + Thread.currentThread().getName()
                            + "СНЯТА, вперёёёёёд! =)");
                },
                "Panda"
        );
        masterShifu.start();
        panda.start();
    }
}
