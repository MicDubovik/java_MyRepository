package ru.job4j.Servlet3.HttpServlets;

import ru.job4j.Servlet3.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * UpdateUsers.
 */
public class UpdateUsers extends HttpServlet {
    /**
     * Init db.
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

        this.initDB.updateUserName(name,login);

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }
}