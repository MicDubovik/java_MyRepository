package ru.job4j.Servlet3.MyHttpServlets;

import ru.job4j.Servlet3.DbConnect.StartConnect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Katy on 16.05.2017.
 */
public class DeleteUsers extends HttpServlet{

    StartConnect connect = new StartConnect();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.setContentType("text,html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");


        this.connect.startToDB();
        this.connect.getInitDB().deleteUserByLogin(login);
        this.connect.close();

        resp.sendRedirect("index.jsp");
    }
}
