package ru.job4j.concurrent;

public class MasterSlaveBarrier {
    private final Object monitor = this;
    private boolean flag = false;

    public void tryMaster() {
        synchronized (monitor) {
            if (flag) {
                this.flag = false;
                monitor.notifyAll();
            }
        }
    }

    public void trySlave() {
        synchronized (monitor) {
            if (!flag) {
                this.flag = true;
                monitor.notifyAll();
            }
        }
    }

    public void doneMaster() {
        synchronized (monitor) {
            while (!flag) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void doneSlave() {
        synchronized (monitor) {
            while (flag) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
