package ru.job4j.SQL_JDBC.JDBC.TrackerDB.TrackerList.Database;

import java.sql.*;

/**
 * Created by Katy on 07.05.2017.
 */
public class InitDB {
//    /**
//     * Table name.
//     */
//    private String tablename;
//    PreparedStatement ps = null;
//    Db db;
//    ItemDB itemDB = new ItemDB();
//    Structure structure = new Structure();
//
//    public InitDB(String dbName, String host, String port, String user, String pass) {
//
//
//        this.db = new Db(dbName, host, port, user, pass);
//    }
//
//    public Db getDb() {
//        return db;
//    }
//
//    public void setDb(Db db) {
//        this.db = db;
//    }
//
//    public String getTablename() {
//        return tablename;
//    }
//
//    public void setTablename(String tablename) {
//        this.tablename = tablename;
//    }
//
//    public Structure getStructure() {
//        return structure;
//    }
//
//    public void setStructure(Structure structure) {
//        this.structure = structure;
//    }
//
//    public void createConnection() {
//
//        this.db.initProperties();
//        this.db.connectToBD();
//
//
//    }
//
//
//    public void createTable(String tableName) {
//
//        this.tablename = tableName;
//        String createTable = "CREATE TABLE " + tableName +
//                " ( " + structure.getId() + " Serial PRIMARY KEY ," +
//                structure.getName() + " VARCHAR (100)," +
//                structure.getDescription() + " VARCHAR (100)," +
//                structure.getComment() + " VARCHAR (100))";
//        try {
//
//            Statement stmt = db.getConnection().createStatement();
//            stmt.execute(createTable);
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//    }
//
//    public void addItem(String name, String description) {
//        String query = "INSERT  INTO tableName ("+structure.getName()+","+structure.getDescription()+") VALUES(?,?)";
//        String newQuery = query.replace("tableName", this.tablename);
//        try {
//            this.ps = this.db.getConnection().prepareStatement(newQuery);
//
//            ps.setString(1, name);
//            ps.setString(2, description);
//
//            ps.execute();
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//    }
//
//    public void update(String id, String name, String description) {
//
//        String update = "UPDATE  tableName SET "+structure.getName()+"= ?,"+structure.getDescription()+"=? WHERE id=?";
//        String newQuery = update.replace("tableName", this.tablename);
//        int newId = Integer.parseInt(id);
//        try {
//            this.ps = this.db.getConnection().prepareStatement(newQuery);
//
//            ps.setString(1, name);
//            ps.setString(2, description);
//            ps.setInt(3, newId);
//
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//    }
//
//    public ResultSet showAllItem() {
//        ResultSet resultSet = null;
//        String query = "SELECT * FROM tableName";
//        String newQuery = query.replace("tableName", this.tablename);
//        try {
//            this.ps = this.db.getConnection().prepareStatement(newQuery);
//
//            resultSet = ps.executeQuery();
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//        showResult(resultSet);
//        return resultSet;
//    }
//
//    public void deleteItemById(String id) {
//        String query = "DELETE  FROM tableName WHERE "+structure.getId()+"=?";
//        String newQuery = query.replace("tableName", this.tablename);
//        int newId = Integer.parseInt(id);
//        try {
//            this.ps = this.db.getConnection().prepareStatement(newQuery);
//
//            ps.setInt(1, newId);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//    }
//
//    public void insertComment(String id, String comments) {
//        String query = "UPDATE tableName SET "+structure.getComment()+" = ?  WHERE "+structure.getId()+"=?";
//        String newQuery = query.replace("tableName", this.tablename);
//        int newId = Integer.parseInt(id);
//        try {
//            this.ps = this.db.getConnection().prepareStatement(newQuery);
//
//            ps.setString(1, comments);
//            ps.setInt(2, newId);
//            ps.execute();
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//    }
//
//    public ResultSet findItemById(String id) {
//        ResultSet resultSet = null;
//        String query = "SELECT * FROM tableName WHERE "+structure.getId()+"=?";
//        String newQuery = query.replace("tableName", this.tablename);
//        int newId = Integer.parseInt(id);
//
//        try {
//            this.ps = this.db.getConnection().prepareStatement(newQuery);
//
//            ps.setInt(1, newId);
//            resultSet = ps.executeQuery();
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//        showResult(resultSet);
//        return resultSet;
//    }
//
//    public ResultSet finfItemByText(String text) {
//        ResultSet resultSet = null;
//        String query = "SELECT  * FROM tableName WHERE "+structure.getComment()
//                +" LIKE ? OR "+structure.getDescription()+" LIKE ?";
//        String newQuery = query.replace("tableName", this.tablename);
//
//        String newText = "%" + text + "%";
//        try {
//            this.ps = this.db.getConnection().prepareStatement(newQuery);
//
//            ps.setString(1, newText);
//            ps.setString(2, newText);
//
//            resultSet = ps.executeQuery();
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//        showResult(resultSet);
//        return resultSet;
//    }
//
//    public void showResult(ResultSet res) {
//
//
//        try {
//            while (res.next()) {
//                itemDB.setId(res.getInt(structure.getId()));
//                itemDB.setName(res.getString(structure.getName()));
//                itemDB.setDescription(res.getString(structure.getDescription()));
//                itemDB.setComment(res.getString(structure.getComment()));
//                System.out.println(itemDB);
//            }
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//    }
//
//    public void columnInit() {
//
//        ResultSet res = null;
//        String query = " select * from "+ this.tablename+" limit 0";
//
//        try {
//            ps = db.getConnection().prepareStatement(query);
//
//            res = ps.executeQuery();
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//
//        ResultSetMetaData data = null;
//        try {
//            data = res.getMetaData();
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//
//
//        try {
//            structure.setId(data.getColumnName(1)) ;
//            structure.setName(data.getColumnName(2));
//            structure.setDescription(data.getColumnName(4));
//            structure.setComment(data.getColumnName(3));
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//
//    }
}

