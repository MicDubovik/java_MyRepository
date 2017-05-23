package ru.job4j.SimpleSign;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Signout.
 */
public class Signout extends HttpServlet {
    /**
     * doGet.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

            session.invalidate();

        req.getRequestDispatcher("/WEB-INF/signin.jsp").forward(req,resp);
    }
}
