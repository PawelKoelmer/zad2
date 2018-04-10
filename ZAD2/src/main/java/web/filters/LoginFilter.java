package web.filters;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(urlPatterns = {"/login.jsp", "/add.jsp"})
public class LoginFilter implements Filter{

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException,ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        if(session.getAttribute("user")!=null){
            ((HttpServletResponse) response).sendRedirect("profile.jsp");
        }
        chain.doFilter(request,response);

    }
    @Override
    public void destroy(){
    }
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
