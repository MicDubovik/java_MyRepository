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
public class DeleteUsers extends HttpServlet{

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
        this.initDB.deleteUserByLogin(login);

        try {
            this.initDB.getPool().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/WEB-INF/AdminEdit.jsp").forward(req,resp);
    }
}
