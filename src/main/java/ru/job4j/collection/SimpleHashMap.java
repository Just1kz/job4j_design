package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable {
    private Node<K, V>[] container;
    private static final double LOAD_F = 0.75;
    private int initialCapacity = 16;
    private int countElement = 0;

    public SimpleHashMap() {
        container = new Node[initialCapacity];
    }

    public boolean insert(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        if (checkLoadFactor()) {
            int input = node.key.hashCode() % container.length;
            if (container[input] != null) {
                return false;
            } else {
                container[input] = node;
            }
        } else {
            resize();
        }
        countElement++;
      return true;
    }

    public void resize() {
        Node<K, V>[] oldContainer = container;
        this.initialCapacity = initialCapacity * 2;
        container = new Node[this.initialCapacity];
        for (int i = 0; i < oldContainer.length; i++) {
            if (oldContainer[i] != null) {
                int inputNew =  oldContainer[i].key.hashCode() % container.length;
                container[inputNew] = oldContainer[i];
            }
        }
    }

    public Node<K, V> get(K key) {
        int input = key.hashCode() % container.length;
        return container[input];
    }

    public boolean delete(K key) {
        int input = key.hashCode() % container.length;
        container[input] = null;
        countElement--;
        return true;
    }

    public boolean checkLoadFactor() {
        return !((double) countElement / container.length >= LOAD_F);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                return count < countElement;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }
        };
    }

    static class Node<K, V> {
        final K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{"
                    + "key="
                    + key
                    + ", value="
                    + value
                    + '}';
        }
    }

    @Override
    public String toString() {
        return "SimpleHashMap{"
                + "container=" + Arrays.toString(container)
                + '}';
    }

    public static void main(String[] args) {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("Anton", 45);
        map.insert("Andrey", 25);
        map.insert("Anton", 35);
        System.out.println(map);
        System.out.println(map.get("Anton"));
        map.delete("Andrey");
        System.out.println(map);
        map.insert("Anton3", 45);
        map.insert("Anton4", 45);
        map.insert("Anton5", 45);
        map.insert("Anton6", 45);
        map.insert("Anton7", 45);
        map.insert("Anton8", 45);
        map.insert("Anton9", 45);
        map.insert("Anton10", 45);
        map.insert("Anton11", 45);
        map.insert("Anton12", 45);
        map.insert("Anton13", 45);
        map.insert("Anton14", 45);
        map.insert("Anton15", 45);
        map.insert("Anton16", 45);
        System.out.println(map);
    }
}

