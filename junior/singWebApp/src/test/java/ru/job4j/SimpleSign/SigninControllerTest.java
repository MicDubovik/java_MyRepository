package ru.job4j.SimpleSign;

import org.junit.Test;
import ru.job4j.Admin.ShowUsers;
import ru.job4j.DbConnect.InitDB;
import ru.job4j.DbConnect.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.booleanThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Katy on 22.05.2017.
 */
public class SigninControllerTest {

    @Test
    public void Signin() throws ServletException, IOException {
        SigninController controller = new SigninController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("login")).thenReturn("mic");
        when(request.getParameter("password")).thenReturn("0101");


        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        controller.doGet(request, response);

        InitDB initDB = new InitDB();
        User user = null;
        boolean flag = false;

        user = initDB.getUserByLogin("mic");
        flag = initDB.CheckPass(user, "mic", "0101");

        assertThat(flag, is(true));


    }

}