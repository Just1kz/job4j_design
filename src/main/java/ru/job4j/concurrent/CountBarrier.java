package ru.job4j.concurrent;

public class CountBarrier {
    private final Object monitor = this;

    private final int total;

    private int count = 0;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public void count() throws InterruptedException {
        synchronized (monitor) {
            count++;
            System.out.println(count);
            monitor.notifyAll();
        }
    }

    public void await() {
        synchronized (monitor) {
            while (count != total) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    //1. Разработайте класс, который блокирует выполнение по условию счетчика.
    //Переменная total содержит количество вызовов метода count().
    //Нити, которые выполняют метод await, могут начать работу если ->
    // поле count == total. Если оно не равно, то нужно перевести нить в состояние wait.
}
