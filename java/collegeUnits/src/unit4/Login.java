// Datavalidation from database in java

package unit4;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login"); //Annotation
public class Login extends HttpServet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<DOCTYPE html>");
        out.println("<html><head><title> Login </title>");
        out.println("<link rel='stylesheet' text='text/css' href='css/style.css'>");
        out.println("</head></body>");
        out.println("<form method='POST' action='/myWeb2025/Login'");
        out.println("Username: <input type='text' name='username' required> <br>");
        out.println("Password: <input type='password' name='password' required> <br>");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, ) {
        PrintWriter out = resoponse.getWriter();
        response.setContentType("text/html");
        String name = request.getParamet
        
        er("name");
    }

    
}
