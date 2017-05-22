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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Katy on 22.05.2017.
 */
public class ShowUsersTest {

    @Test
    public void ShowUsers() throws ServletException, IOException {
        ShowUsers showUsers = new ShowUsers();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

//        when(request.getParameter("login")).thenReturn("goga");


        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        showUsers.doGet(request, response);

        List<User> userList = new ArrayList<>();

        InitDB initDB = new InitDB();
        try {

            initDB.getPool().getConnection();
            initDB.getAllUsers();
            userList = initDB.getUserList();
            initDB.getPool().getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertThat(userList.get(0).getLogin(), is("apetr"));
    }

}