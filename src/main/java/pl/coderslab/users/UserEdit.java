package pl.coderslab.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        User user = userDao.read(Integer.parseInt((String) request.getParameter("id")));

        request.setAttribute("userEDIT", user);
        request.getRequestDispatcher("/users/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User user = new User();


        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        user.setId(id);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);

        userDao.update(user);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/users/show.jsp").forward(request, response);
    }
}