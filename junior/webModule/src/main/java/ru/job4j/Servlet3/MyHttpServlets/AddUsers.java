package ru.job4j.Servlet3.MyHttpServlets;

import ru.job4j.Servlet3.DbConnect.StartConnect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Katy on 16.05.2017.
 */
public class AddUsers extends HttpServlet {
    /**
     * Connect to db.
     */
    StartConnect connect = new StartConnect();

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

        this.connect.startToDB();
        this.connect.getInitDB().addUser(name,login,email);
        this.connect.close();
        resp.sendRedirect("index.jsp");

    }
}
