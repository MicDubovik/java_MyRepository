package ru.job4j.ConsoleChat;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConsoleChatTest {

    @Test
    public void startTest() throws IOException {
        ConsoleChat chat = new ConsoleChat();


        chat.sb = new StringBuilder();

        chat.start();

        assertThat( chat.sb.toString(),is("rethfgjghjghkghkhjkhjjlk\r\n"));
    }
    @Test
    public void readTest() throws IOException {
        ConsoleChat chat = new ConsoleChat();

        chat.read();
        assertThat( chat.getAsk() ,is("hello"));
    }
    @Test
    public void contTest(){



    }
    @Test
    public void cycleTest() {

    }


}