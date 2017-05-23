package ru.job4j.MapForBank;

/**
 * UserActionBank
 */
public interface UserActionBank {
    /**
     * Key.
     * @return
     */
    int key();

    /**
     * execute.
     * @param input
     * @param bank
     */
    void execute(InputBank input,Bank bank);

    /**
     * info.
     * @return
     */
    String info();
}
