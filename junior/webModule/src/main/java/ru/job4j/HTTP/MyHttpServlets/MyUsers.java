package ru.job4j.HTTP.MyHttpServlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.HTTP.DbConnect.StartConnect;
import ru.job4j.MyFirstServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by Katy on 15.05.2017.
 */

public class MyUsers extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger MYLOGGER = LoggerFactory.getLogger(MyFirstServlet.class);
    /**
     * List.
     */
     StartConnect connect = new StartConnect();

    /**
     * doGet.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text,html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        this.connect.startToDB();
        this.connect.getInitDB().getAllUsers();
        writer.append("Users :" + this.connect.getInitDB().getUserList() );
        this.connect.close();
        writer.flush();
    }

    /**
     * doPost
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


    }

    /**
     * doPut.
     * @param req
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text,html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");


        this.connect.startToDB();
        this.connect.getInitDB().updateUserName(name,login);
        this.connect.close();

    }

    /**
     * doDelete.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text,html");

        String login = req.getParameter("login");


        this.connect.startToDB();
        this.connect.getInitDB().deleteUserByLogin(login);
        this.connect.close();

    }
}
