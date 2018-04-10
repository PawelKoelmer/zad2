package web.filters;

import domain.User;
import repository.DummyUserRepository;
import repository.UserRepositoryInterface;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter("/add.jsp")
public class UserNameFilter implements Filter {
    UserRepositoryInterface repository;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        repository = new DummyUserRepository();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        List<User> users = repository.getAll();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        for (User use : users) {
            if(use.getUsername().equals(session.getAttribute("un"))) {
                response.getWriter().println("Istnieje uzytkownik o takim loginie");
                return;
            }
        }

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
