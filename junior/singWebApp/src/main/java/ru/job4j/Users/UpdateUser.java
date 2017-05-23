package ru.job4j.Users;

import ru.job4j.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Katy on 16.05.2017.
 */
public class UpdateUser extends HttpServlet {

    InitDB initDB = new InitDB();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text,html");
        String name = req.getParameter("name");
        String login = ((String) req.getSession().getAttribute("login"));


        this.initDB.updateUserName(name,login);


        req.getRequestDispatcher("/WEB-INF/UserEdit.jsp").forward(req,resp);
    }
}
