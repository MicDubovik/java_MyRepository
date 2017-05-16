package ru.job4j.HTTP.DbConnect;

/**
 * Created by Katy on 15.05.2017.
 */
public class StartConnect {

    private InitDB initDB = new InitDB("items_db", "localhost", "5432", "postgres", "123", "servlet");

    public InitDB getInitDB() {
        return initDB;
    }

    public void startToDB()   {
        try {
            initDB.createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        initDB.getDb().closeConnect();
    }


}
