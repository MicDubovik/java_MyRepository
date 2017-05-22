package ru.job4j.Admin;

import ru.job4j.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Katy on 19.05.2017.
 */
public class ShowUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InitDB initDB = new InitDB();

        try {
            initDB.getPool().getConnection();
            initDB.getAllUsers();
            req.setAttribute("users",initDB.getUserList());
            initDB.getPool().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            req.getRequestDispatcher("/WEB-INF/showUsers.jsp").forward(req, resp);

    }
}