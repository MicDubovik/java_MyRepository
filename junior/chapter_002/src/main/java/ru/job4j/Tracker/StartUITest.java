package ru.job4j.Tracker;

/**
 * Created by Katy on 01.03.2017.
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[]{"1","old task","old newdesc","4","8"});
        //  Input input = new ConsoleInput();
        new StartUI(input).init();



    }
}
