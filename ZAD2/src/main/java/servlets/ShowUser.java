package servlets;

import domain.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile.jsp")

public class ShowUser extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");

        response.getWriter().print("Username: " + user.getUsername() + "<br>" + " Type: " + user.getType() + "<br>" + " E-mail: " + user.getEmail());

        if(user.getType().equals("Premium") || user.getType().equals("Admin")){
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<br> <a href=\"/premium.jsp\">Premium</a>");
        }
        if(user.getType().equals(("Admin"))){
            response.getWriter().print(("<br> <a href=\"/premiumadd.jsp\">Nadaj Premium</a>"));
        }

    }
}
