package ru.job4j.concurrent;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private Map<Integer, UserX> data = new HashMap<>();

    synchronized boolean add(UserX user) {
        data.put(user.getId(), user);
        return data.containsValue(user);
    }
    synchronized boolean update(UserX user) {
        UserX rsl = data.put(user.getId(), user);
        return rsl != null;
    }
    synchronized boolean delete(UserX user) {
        return data.remove(user.getId(), user);
    }

    synchronized boolean transfer(int fromId, int toId, int amount) {
        UserX fromUx = data.get(fromId);
        UserX toUx = data.get(toId);
        if ((fromUx != null && toUx != null) && fromUx.getAmount() >= amount) {
            fromUx.setAmount(fromUx.getAmount() - amount);
            toUx.setAmount(toUx.getAmount() + amount);
        }
        UserX afterTransfer = data.get(fromId);
        return fromUx.getAmount() < afterTransfer.getAmount();
    }
}
