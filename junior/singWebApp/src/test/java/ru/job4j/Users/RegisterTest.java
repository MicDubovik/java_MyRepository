package ru.job4j.Users;

import org.junit.Test;

import ru.job4j.Admin.AddUsers;
import ru.job4j.DbConnect.InitDB;
import ru.job4j.DbConnect.User;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Katy on 22.05.2017.
 */
public class RegisterTest {

    @Test
    public void Registertest() throws ServletException, IOException {
        Register register = new Register();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher  = mock(RequestDispatcher.class);


        when(request.getParameter("name")).thenReturn("Gosha");
        when(request.getParameter("login")).thenReturn("goga");
        when(request.getParameter("password")).thenReturn("1111");
        when(request.getParameter("email")).thenReturn("goga@mail.ru");

        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        HttpSession session = request.getSession();

        register.doPost(request, response);
        String error = (String) session.getAttribute("error");
        User user = null;

        InitDB initDB = new InitDB();
        try {

            initDB.getPool().getConnection();
            user = initDB.getUserByLogin("goga");
            initDB.getPool().getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        assertThat(user.getLogin(), is("goga"));
    }

}