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


@WebServlet("/add")
public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        final String url = "jdbc:hsqldb:hsql://localhost/workdb";
        final String usr = "SA";
        final String pas = "";

        User user = retriveUserFromRequest(request);
        UserRepositoryInterface repository = new DummyUserRepository();
        List<User> users = repository.getAll();
        StringBuilder userString = new StringBuilder();


        if(user.getPassword().equals(request.getParameter("confpass"))
                && request.getParameter("username")!=null
                && request.getParameter("password")!=null
                && request.getParameter("confpass")!=null
                && request.getParameter("email")!=null
                ) {
            HttpSession session = request.getSession();
            session.setAttribute("conf", user);
            session.setAttribute("un",user.getUsername());
            repository.add(user);
            response.getWriter().print(userString);
            response.sendRedirect("login.jsp");
        }
        else{
            response.sendRedirect("add1.jsp");
        }


//        try {
//            Class.forName("org.hsqldb.jdbc.JDBCDriver");
//        } catch (Exception e) {
//            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
//            e.printStackTrace();
//            return;
//        }
//        try {
//            Connection c = DriverManager.getConnection(url, usr, pas);
//            response.getWriter().print("Udalo sie");
//            UserDbManager userDB = new UserDbManager();
//            response.getWriter().print("Niby utworzylem");
////            userDB.add(user);
//
//        } catch (SQLException e) {
//            response.getWriter().print("Blad");
//            e.printStackTrace();
//        }




    }
    private User retriveUserFromRequest(HttpServletRequest request){
        User newUser = new User();
        newUser.setUsername(request.getParameter("username"));
        newUser.setPassword(request.getParameter("password"));
        newUser.setEmail(request.getParameter("email"));
        newUser.setType("standard");
        return newUser;
    }

}
