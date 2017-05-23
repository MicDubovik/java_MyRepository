package ru.job4j.Servlet3.HttpServlets;

import ru.job4j.Servlet3.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * DeleteUsers.
 */
public class DeleteUsers extends HttpServlet{

    InitDB initDB = new InitDB();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text,html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");

        this.initDB.deleteUserByLogin(login);


        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }
}