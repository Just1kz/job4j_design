package ru.job4j.concurrent;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private Map<Integer, People> data = new HashMap<>();

    synchronized boolean add(People user) {
        data.put(user.getId(), user);
        return data.containsValue(user);
    }
    synchronized boolean update(People user) {
        People rsl = data.put(user.getId(), user);
        return rsl != null;
    }
    synchronized boolean delete(People user) {
        return data.remove(user.getId(), user);
    }

    synchronized boolean transfer(int fromId, int toId, int amount) {
        People fromUx = data.get(fromId);
        People toUx = data.get(toId);
        if ((fromUx != null && toUx != null) && fromUx.getAmount() >= amount) {
            fromUx.setAmount(fromUx.getAmount() - amount);
            toUx.setAmount(toUx.getAmount() + amount);
        }
        People afterTransfer = data.get(fromId);
        return fromUx.getAmount() < afterTransfer.getAmount();
    }
}
