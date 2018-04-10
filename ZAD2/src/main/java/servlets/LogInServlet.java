package servlets;

import org.hsqldb.Session;
import repository.DummyUserRepository;
import repository.UserRepositoryInterface;
import domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
    UserRepositoryInterface repository;

    public void init() {
        repository = new DummyUserRepository();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<User> users = repository.getAll();
        HttpSession session = request.getSession(true);
        String login = request.getParameter("username");
        String pass = request.getParameter("password");

        for (User use : users) {

            if(login.equals(use.getUsername()) && pass.equals((use.getPassword()))) {
                session.setAttribute("user",use);
                response.sendRedirect("profile.jsp");
            }
        }
        response.sendRedirect("unsuccesfullogin.jsp");


    }
}
