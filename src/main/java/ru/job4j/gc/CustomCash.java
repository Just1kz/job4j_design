package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class CustomCash {
    private final Map<String, SoftReference> data = new HashMap<>();

    public SoftReference get(String key) {
        SoftReference result = null;
        if (data.containsKey(key)) {
            result = data.get(key);
        }
        return result;
    }

    public void add(String key, String value) {
        SoftReference<String> softReference = new SoftReference(value);
        data.put(key, softReference);
    }
}
