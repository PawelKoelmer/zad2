package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter ("/add")
public class ApplicationDataInSessionFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
     throws IOException,ServletException{
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        if(session.getAttribute("conf")!=null){
            response.getWriter().println("Juz sie zarejestrowano");
            return;
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
