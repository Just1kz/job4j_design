package ru.job4j.generics;

public class UserStore implements Store<User> {

    private final Store<User> storeUser = new MemStore<>();

    @Override
    public void add(User model) {
        storeUser.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return storeUser.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return storeUser.delete(id);
    }

    @Override
    public User findById(String id) {
        return storeUser.findById(id);
    }

}