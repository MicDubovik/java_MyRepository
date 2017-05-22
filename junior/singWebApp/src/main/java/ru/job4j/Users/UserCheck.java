package ru.job4j.Users;

import ru.job4j.DbConnect.InitDB;
import ru.job4j.DbConnect.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Katy on 21.05.2017.
 */
public class UserCheck extends HttpServlet {

    InitDB initDB = new InitDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getSession().getAttribute("role").equals("1")) {
            req.getRequestDispatcher("WEB-INF/AdminEdit.jsp").forward(req, resp);
        } else {

            req.getRequestDispatcher("WEB-INF/UserEdit.jsp").forward(req, resp);
        }


    }


}
