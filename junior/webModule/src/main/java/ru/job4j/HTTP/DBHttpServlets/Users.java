package ru.job4j.HTTP.DBHttpServlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.HTTP.DbConnect.ConnectionPool;
import ru.job4j.FirstServlet;
import ru.job4j.HTTP.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * Created by Katy on 15.05.2017.
 */

public class Users extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger MYLOGGER = LoggerFactory.getLogger(FirstServlet.class);
    /**
     * List.
     */
     InitDB initDB = new InitDB();

    public Users() throws SQLException, ClassNotFoundException {
    }

    /**
     * doGet.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text,html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        try {
            this.initDB.getPool().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.initDB.getAllUsers();
        writer.append("Users :" + this.initDB.getUserList() );
        try {
            this.initDB.getPool().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.flush();
    }

    /**
     * doPost
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text,html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");

        try {
            this.initDB.getPool().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.initDB.addUser(name, login, email);
        try {
            this.initDB.getPool().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * doPut.
     * @param req
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text,html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");

        try {
            this.initDB.getPool().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.initDB.updateUserName(name,login);
        try {
            this.initDB.getPool().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * doDelete.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text,html");

        String login = req.getParameter("login");
        try {
            this.initDB.getPool().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.initDB.deleteUserByLogin(login);
        try {
            this.initDB.getPool().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
