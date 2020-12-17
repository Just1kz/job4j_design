package ru.job4j.generics;

public class RoleStore implements Store<Role> {

    private final Store<Role> storeRole = new MemStore<>();

    @Override
    public void add(Role model) {
    storeRole.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return storeRole.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return storeRole.delete(id);
    }

    @Override
    public Role findById(String id) {
        return storeRole.findById(id);
    }
}
