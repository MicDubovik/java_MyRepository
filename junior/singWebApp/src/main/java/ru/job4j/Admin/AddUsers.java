package ru.job4j.Admin;

import ru.job4j.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Katy on 16.05.2017.
 */
public class AddUsers extends HttpServlet {
    /**
     * Connect to db.
     */
    InitDB initDB = new InitDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/AdminEdit.jsp").forward(req,resp);
    }

    /**
     * DoPost.
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
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        try {
            this.initDB.getPool().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.initDB.addUser(name,login,email,password);

        try {
            this.initDB.getPool().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

         doGet(req,resp);


    }
}
