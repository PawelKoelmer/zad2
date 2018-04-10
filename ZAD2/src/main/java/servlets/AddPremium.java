package servlets;

import domain.User;
import repository.DummyUserRepository;
import repository.UserRepositoryInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/premiumadd")
public class AddPremium extends HttpServlet{
    UserRepositoryInterface repository;

    public void init() {
        repository = new DummyUserRepository();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        List<User> users = repository.getAll();
        String name = request.getParameter("username");
        for(User use : users){
            if(use.getUsername().equals(name)){
                use.setType("Premium");
            }
        }

    }
}
