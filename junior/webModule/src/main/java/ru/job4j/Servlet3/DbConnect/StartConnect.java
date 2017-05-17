package ru.job4j.Servlet3.DbConnect;

/**
 * Created by Katy on 15.05.2017.
 */
public class StartConnect {
    /**
     * Field for connection.
     */
    private InitDB initDB = new InitDB("items_db", "localhost", "5432", "postgres", "123", "servlet");

    /**
     * Get Init.
     * @return
     */
    public InitDB getInitDB() {
        return initDB;
    }

    /**
     * Start connection.
     */
    public void startToDB()   {
        try {
            initDB.createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close connection.
     */
    public void close() {
        initDB.getDb().closeConnect();
    }


}
