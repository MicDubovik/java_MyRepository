package ru.job4j.Generic;

public class RoleStore implements Store<Role> {

    int size = 5;

    SimpleArray<Role> roleSimple = new SimpleArray<>(size);

    @Override
    public void add(Role obj) {
        this.roleSimple.add(obj);
    }

    @Override
    public void update(Role obj, String id) {

        this.roleSimple.update(obj, getIndexById(id));
    }

    @Override
    public void delete(String id) {
        this.roleSimple.delete(getIndexById(id));
    }

    @Override
    public Role get(String id) {
        return this.roleSimple.get(getIndexById(id));
    }

    private Integer getIndexById(String id) {
        Integer result = -1;
        for (int index = 0; index < this.size; index++) {
            if (this.roleSimple.get(index) != null && id.equals(this.roleSimple.get(index).getId())) {
                result = index;
                break;
            }
        }
        return result;
    }
}
