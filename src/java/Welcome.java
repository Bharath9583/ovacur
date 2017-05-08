import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Welcome extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String user = (String)session.getAttribute("user");
        out.println("<html><head><title>User Page</title></head><html>");
        out.println("Welcome "+user);
        out.println("<br>");
        out.println("<br>");
        out.println("<a href=index.html>Home Page</a>");
      }  
}