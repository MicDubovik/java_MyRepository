package ru.job4j.Servlet3.HttpServlets;

import ru.job4j.Servlet3.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * ShowUsers.
 */
public class ShowUsers extends HttpServlet {
    /**
     * DoGet.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InitDB initDB = new InitDB();

            initDB.getAllUsers();
            req.setAttribute("users",initDB.getUserList());

        req.getRequestDispatcher("/WEB-INF/showUsers.jsp").forward(req, resp);

    }
}