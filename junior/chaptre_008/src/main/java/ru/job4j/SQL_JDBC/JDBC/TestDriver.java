package ru.job4j.SQL_JDBC.JDBC;

import java.sql.*;

/**
 * Created by Katy on 07.05.2017.
 */
public class TestDriver {

    public static void main(String[] args) {

        try {
            System.out.println(Class.forName("org.postgresql.Driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
