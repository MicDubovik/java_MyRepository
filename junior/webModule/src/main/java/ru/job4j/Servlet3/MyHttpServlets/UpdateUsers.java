package ru.job4j.Servlet3.MyHttpServlets;

import ru.job4j.Servlet3.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Katy on 16.05.2017.
 */
public class UpdateUsers extends HttpServlet {

    InitDB initDB = new InitDB();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        resp.sendRedirect("index.jsp");
    }
}
