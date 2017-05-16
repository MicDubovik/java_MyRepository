package ru.job4j.HTTP.DbConnect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

/**
 * Created by Katy on 07.05.2017.
 */
public class Db {

    private static final Logger log = LoggerFactory.getLogger(Db.class);

    private final String dbName;
    private String host;
    private String port;
    private String user;
    private String password;
    private String url;
    private Connection connection;
    private Properties properties = new Properties();

    /**
     * Constructor.
     *
     * @param dbName
     * @param host
     * @param port
     * @param user
     * @param password
     */
    public Db(String dbName, String host, String port, String user, String password) {
        this.dbName = dbName;
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.url = "jdbc:postgresql://" + host + ":" + port + "/";


    }

    /**
     * Get connection
     *
     * @return
     */
    public Connection getConnection() {
        return connection;
    }


    /**
     * Initialize properties.
     */
    public void initProperties() {

        properties.setProperty("user", user);
        properties.setProperty("password", password);
        properties.setProperty("characterEncoding", "UTF-8");
        properties.setProperty("useUnicode", "true");


    }

    /**
     * Connection to db.
     */
    public void connectToBD()   {

        String newUrl = this.url + this.dbName;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            this.connection = DriverManager.getConnection(newUrl, user, password);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);

            e.printStackTrace();


        }
        System.out.printf("Success connect to %s\n", newUrl);
    }

    /**
     * Close connection.
     */

    public void closeConnect() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }
}