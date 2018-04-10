package servlets;

import domain.User;
import org.hsqldb.Session;
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

@WebServlet("premiumadd.jsp")
public class ShowAllWithStatus extends HttpServlet {

    UserRepositoryInterface repository;
    public void init() {
        repository = new DummyUserRepository();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {

        List<User> users = repository.getAll();
        for (User user : users) {
            response.getWriter().print("Username: " + user.getUsername() + "\t Type: " + user.getType() + "\t E-mail: " + user.getEmail() + "\n");
        }
        response.getWriter().print("<form action=\"premium\" method=\"post\">" +
                "            <label>Username: <input type=\"text\" id=\"uesrname\" name=\"username\"></label><br>" +
                "            <input type=\"submit\" value=\"wyslij\">" +
                "            </form>");
    }

}
