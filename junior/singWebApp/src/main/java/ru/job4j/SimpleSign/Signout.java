package ru.job4j.SimpleSign;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Katy on 21.05.2017.
 */
public class Signout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        synchronized (session){
            session.invalidate();
        }
        req.getRequestDispatcher("/WEB-INF/signin.jsp").forward(req,resp);
    }
}
