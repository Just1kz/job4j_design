package ru.job4j.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cash {
    private final Map<Integer, Base> cache = new ConcurrentHashMap<>();

    public boolean add(Base base) {
        cache.putIfAbsent(base.getId(), base);
        return cache.get(base.getId()) == base;
    }

    public void update(Base base) {
        cache.computeIfPresent(base.getId(), (key, oldValue) -> {
            if (base.getVersion() != oldValue.getVersion()) {
                throw new OptimisticException("Invalid version");
            }
            oldValue.setVersion(oldValue.getVersion() + 1);
            return oldValue;
        });
    }

    public Base delete(Base base) {
        return cache.remove(base.getId());
    }

}
