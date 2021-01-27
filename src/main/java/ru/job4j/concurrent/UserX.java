package ru.job4j.concurrent;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class UserX {
    @GuardedBy("this")
    private int id;
    @GuardedBy("this")
    private int amount;

    public UserX(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized void setId(int id) {
        this.id = id;
    }

    public synchronized int getAmount() {
        return amount;
    }

    public synchronized void setAmount(int amount) {
        this.amount = amount;
    }
}
