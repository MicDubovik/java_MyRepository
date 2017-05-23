package ru.job4j.Servlet3.HttpServlets;

import ru.job4j.Servlet3.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * AddUsers.
 */
public class AddUsers extends HttpServlet {
    /**
     * Connect to db.
     */
    InitDB initDB = new InitDB();


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
        String email = req.getParameter("email");

        this.initDB.addUser(name,login,email);

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);

    }
}