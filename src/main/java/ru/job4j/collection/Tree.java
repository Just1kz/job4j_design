package ru.job4j.collection;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Queue;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> nodeParent = findBy(parent);
        if (nodeParent.isEmpty()) {
            return false;
        } else {
            if (findBy(child).isEmpty()) {
                nodeParent.get().children.add(new Node<>(child));
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    public boolean isBinary() {
        Queue<Node<E>> linkedList = new LinkedList<>();
        linkedList.offer(root);
        while (!linkedList.isEmpty()) {
            Node<E> rsl = linkedList.poll();
            for (Node<E> child : rsl.children) {
                linkedList.offer(child);
            }
            if (rsl.children.size() > 2) {
                return false;
            }
        }
        return true;
    }
}
