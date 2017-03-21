package ru.job4j.MapForBank;

public abstract class BaseActionBank implements UserActionBank {

    /**
     * Имя метода.
     */
    private String name;
    /**
     * Конструктор принимающий имя метода.
     * @param name name.
     */
    BaseActionBank(String name) {
        this.name = name;
    }
    /**
     * Ключ действия.
     * @return key.
     */
    public abstract int key();
    /**
     * Действия метода.
     * @param input input.
     * @param bank bank.
     */
    public abstract void execute(InputBank input, Bank bank);
    /**
     * Информация о методе.
     * @return name.
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }

}

