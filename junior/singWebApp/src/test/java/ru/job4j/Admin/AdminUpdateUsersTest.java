package ru.job4j.Admin;

import org.junit.Test;
import ru.job4j.DbConnect.InitDB;
import ru.job4j.DbConnect.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test servlet AdminUpdateUsers.
 */
public class AdminUpdateUsersTest {

    @Test
    public void UpdateUsersTest() throws ServletException, IOException {
        AdminUpdateUsers adminUpdateUsers = new AdminUpdateUsers();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getParameter("name")).thenReturn("Gosha");
        when(request.getParameter("login")).thenReturn("vic");

        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        adminUpdateUsers.doPost(request, response);

        User user = null;

        InitDB initDB = new InitDB();

        user = initDB.getUserByLogin("vic");

        assertThat(user.getName(), is("Gosha"));
    }

}