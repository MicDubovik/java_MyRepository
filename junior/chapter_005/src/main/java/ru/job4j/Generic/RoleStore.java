package ru.job4j.Generic;

public class RoleStore implements Store<Role> {

    SimpleArray<Role> roleSimple = new SimpleArray<>(5);

    @Override
    public void add(Role obj) {
        this.roleSimple.add(obj);
    }

    @Override
    public void update(Role obj, int index) {
        this.roleSimple.update(obj, index);
    }

    @Override
    public void delete(int index) {
        this.roleSimple.delete(index);
    }

    @Override
    public Role get(int index) {
        return this.roleSimple.get(index);
    }
}
