package ru.job4j.Admin;



import ru.job4j.DbConnect.InitDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * DeleteUsers.
 */
public class DeleteUsers extends HttpServlet{
    /**
     * Init db.
     */
    InitDB initDB = new InitDB();

    /**
     * doPost.
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

        this.initDB.deleteUserByLogin(login);

        req.getRequestDispatcher("/WEB-INF/AdminEdit.jsp").forward(req,resp);
    }
}
