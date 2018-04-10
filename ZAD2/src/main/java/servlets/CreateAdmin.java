package servlets;

import domain.User;
import repository.DummyUserRepository;
import repository.UserRepositoryInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class CreateAdmin extends HttpServlet {

    UserRepositoryInterface repository;

    public void init() {
        repository = new DummyUserRepository();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<User> users = repository.getAll();

        if(users.size()<1)
        {
            User user=createAdmin();
            repository.add(user);
        }
        response.getWriter().print("<a href=\"/login.jsp\">Logowanie</a><br>");
        response.getWriter().print(" <a href=\"/add.jsp\">Rejestracja</a>");
    }


    private User createAdmin(){
        User newUser = new User();
        newUser.setUsername("Admin");
        newUser.setPassword("admin");
        newUser.setEmail("admin@projekt.pl");
        newUser.setType("Admin");
        return newUser;
    }
}
