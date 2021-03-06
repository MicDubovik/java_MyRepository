package ru.job4j.SimpleSign;

import ru.job4j.DbConnect.InitDB;
import ru.job4j.DbConnect.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Katy on 21.05.2017.
 */
public class SigninController extends HttpServlet {
    /**
     * Init db.
     */
    InitDB initDB = new InitDB();

    /**
     * doGet.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/WEB-INF/signin.jsp").forward(req, resp);
    }

    /**
     * doPost.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");


            User user = initDB.getUserByLogin(login);
            if (user.getLogin()!= null) {
                if (initDB.CheckPass(user, login, password)) {
                    HttpSession session = req.getSession();
                    synchronized (session) {

                        session.setAttribute("login", login);
                        session.setAttribute("role", user.getRole());

                    }

                    resp.sendRedirect(String.format("%s/", req.getContextPath()));
                }

            } else {
                req.setAttribute("error", "Credential invalid");
                doGet(req, resp);
            }
    }
}
