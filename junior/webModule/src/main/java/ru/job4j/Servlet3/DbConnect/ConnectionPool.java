package ru.job4j.Servlet3.DbConnect;


import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ConnectionPool.
 */
public class ConnectionPool {
    /**
     * BasicDataSource.
     */
    private BasicDataSource source = new BasicDataSource();
    /**
     * Connection.
     */
    private Connection connection;

    /**
     * Constructor.
     */
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

    /**
     * Get connection.
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return connection = source.getConnection( );
    }

}