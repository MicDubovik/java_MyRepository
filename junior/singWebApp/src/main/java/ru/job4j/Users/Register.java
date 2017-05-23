package ru.job4j.Users;

import ru.job4j.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Katy on 21.05.2017.
 */
public class Register extends HttpServlet {

    InitDB initDB = new InitDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("name");
       String login = req.getParameter("login");
       String password = req.getParameter("password");
       String email = req.getParameter("email");

           if (this.initDB.addUser(name,login,email,password)){
               req.setAttribute("error", "User already exist");
               doGet(req, resp);
           }

       resp.sendRedirect(String.format("%s/Signin",req.getContextPath()));
    }
}
