package ru.job4j.concurrent;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final int size = Runtime.getRuntime().availableProcessors();
    //Инициализация пула должна быть по количеству ядер в системе.

    private final List<Thread> threads = new LinkedList<>();

    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(100);

    private void threadsCreate() {
        for (int x = 0; x < size; x++) {
            threads.add(new Thread(() -> {
                //Количество нитей всегда одинаковое и равно size.
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        Runnable job = tasks.poll();
                        //В каждую нить передается блокирующая очередь tasks.
                        //В методе run мы должны получить задачу их очереди tasks.
                        job.run();
                    }
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }));
        }
    }

    public void work(Runnable job) {
        if (threads.isEmpty()) {
            threadsCreate();
        }
        tasks.offer(job);
    }

    public void shutdown() {
        threads.forEach(Thread::interrupt);
    }

    //В каждую нить передается блокирующая очередь tasks.
    //Количество нитей всегда одинаковое и равно size.
    //В методе run мы должны получить задачу их очереди tasks.
    //tasks - это блокирующая очередь. Если в очереди нет элементов, то нить переводиться в состоянии waiting.
    //Когда приходит новая задача, всем нитям в состоянии waiting посылается сигнал проснуться и начать работу.
    //2. Создать метод work(Runnable job). - этот метод должен добавлять задачи в блокирующую очередь tasks.
}
