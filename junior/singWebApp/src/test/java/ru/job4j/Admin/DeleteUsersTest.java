package ru.job4j.Admin;

import org.junit.Test;
import ru.job4j.DbConnect.InitDB;
import ru.job4j.DbConnect.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class DeleteUsersTest {

    @Test
    public void DeleteUsertest() throws ServletException, IOException {
        DeleteUsers deleteUsers = new DeleteUsers();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("login")).thenReturn("goga");


        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        deleteUsers.doPost(request, response);

        User user = null;

        InitDB initDB = new InitDB();

            user = initDB.getUserByLogin("goga");

        String login=null;
        if (user.getLogin()==null){
             login = "empty";
        }


        assertThat(login, is("empty"));
    }

}