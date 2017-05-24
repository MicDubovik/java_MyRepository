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
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 * Created by Katy on 22.05.2017.
 */
public class RegisterTest {

    // Вводим существующего пользователя и проверяем атрибут error .
    // Если тест проходит значит регистрация верна и мы не можем занести в базу нового пользователя.
    @Test
    public void Registertest() throws ServletException, IOException {
        Register register = new Register();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher  = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getParameter("name")).thenReturn("Gosha");
        when(request.getParameter("login")).thenReturn("voga");
        when(request.getParameter("password")).thenReturn("2311");
        when(request.getParameter("email")).thenReturn("goga@mail.ru");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getSession()).thenReturn(session);
        when(request.getAttribute("error")).thenReturn("hello");

        register.doPost(request, response);
        String error = (String) request.getAttribute("error");

        assertThat(error, is("hello"));
    }

}