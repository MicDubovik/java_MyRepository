package ru.job4j.Users;

import org.junit.Test;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Katy on 22.05.2017.
 */
public class UpdateUserTest {
    @Test
    public void UpdateUserMethod() throws ServletException, IOException {
        UpdateUser updateUser = new UpdateUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);

//
        when(request.getParameter("name")).thenReturn("Gosha");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("login")).thenReturn("goga");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        updateUser.doPost(request, response);

        User user = null;

        InitDB initDB = new InitDB();

        user = initDB.getUserByLogin("goga");

        assertThat(user.getName(), is("Gosha"));
    }

}