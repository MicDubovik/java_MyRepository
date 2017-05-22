package ru.job4j.Admin;

import ru.job4j.DbConnect.InitDB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Admin page for Update user.
 */
public class AdminUpdateUsers extends HttpServlet {

    InitDB initDB = new InitDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/AdminEdit.jsp").forward(req,resp);
    }

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
            doGet(req,resp);
//        req.getRequestDispatcher("/WEB-INF/AdminEdit.jsp").forward(req,resp);
    }
}
