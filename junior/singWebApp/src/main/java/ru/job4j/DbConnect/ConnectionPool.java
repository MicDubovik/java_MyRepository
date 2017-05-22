package ru.job4j.DbConnect;


import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Katy on 18.05.2017.
 */
public class ConnectionPool {

   private BasicDataSource source = new BasicDataSource();

   private Connection connection;


    public ConnectionPool()   {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        source.setDriverClassName("org.postgresql.Driver");
        source.setUsername("postgres");
        source.setPassword("123");
        source.setUrl("jdbc:postgresql://localhost:5432/items_db");


    }

    public Connection getConnection() throws SQLException {
        return connection = source.getConnection( );
    }

}
