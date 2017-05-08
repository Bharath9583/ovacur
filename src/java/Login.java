import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(Validate.checkUser(username, password))
        {
            HttpSession session = request.getSession();
            session.setAttribute("user",username);
            response.sendRedirect("Welcome?user_name="+username+"");
        }
        else
        {
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           out.println("<html><body><center>Your login and password are valid.<br>");
           out.println("</center></body></html>");
           out.println("<br>");           
           rs.include(request, response);
        }
    }  
}