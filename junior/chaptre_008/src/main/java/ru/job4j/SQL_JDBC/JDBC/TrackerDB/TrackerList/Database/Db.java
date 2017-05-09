package ru.job4j.SQL_JDBC.JDBC.TrackerDB.TrackerList.Database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
     * Create db.
     */
//    public void createDB() {
//
//          Statement statement=null;
//        try {
//
//            connection = DriverManager.getConnection(this.url, this.user, this.password);
//            statement = this.connection.createStatement();
//
//            String dbcreate = "CREATE DATABASE " + this.dbName;
//            statement.executeUpdate(dbcreate);
//
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    log.error(e.getMessage(), e);
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    log.error(e.getMessage(), e);
//                }
//            }
//        }
//    }

    /**
     * Connection to db.
     */
    public void connectToBD() {

        String newUrl = this.url + this.dbName;

        try {
            this.connection = DriverManager.getConnection(newUrl, user, password);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);

        }
            System.out.printf("Success connect to %s\n",newUrl);


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
