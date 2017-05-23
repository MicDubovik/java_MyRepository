package ru.job4j.Admin;

import ru.job4j.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * ShowUsers.
 */
public class ShowUsers extends HttpServlet {
    /**
     * doGet.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * Init db.
         */
        InitDB initDB = new InitDB();

        initDB.getAllUsers();
        req.setAttribute("users", initDB.getUserList());

        req.getRequestDispatcher("/WEB-INF/showUsers.jsp").forward(req, resp);

    }
}