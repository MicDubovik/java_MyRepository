package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Katy on 13.05.2017.
 */

public class MyFirstServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger MYLOGGER = LoggerFactory.getLogger(MyFirstServlet.class);
    /**
     * List.
     */
    private List<String> users = new CopyOnWriteArrayList<String>();

    /**
     * DoGET.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("Hello Servlet! ,HI "+this.users);
        writer.flush();

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
        resp.setContentType("text/html");
        this.users.add(req.getParameter("login"));
        System.out.println("Users "+this.users);
        doGet(req,resp);
    }
}

