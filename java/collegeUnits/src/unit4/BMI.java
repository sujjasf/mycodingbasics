package unit4;

// Create a jsp program to accept student name, roll number and marks in five subjects.
// Calculate total, percentage, and display divison.

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bmi") // access via /bmi
public class BMI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!doctype html><html><head><meta charset='utf-8'><title>Marks Form</title></head><body>");
        out.println("<h2>Enter Student Details</h2>");
        out.println("<form method='post' action='" + req.getContextPath() + "/bmi'>");
        out.println("Name: <input type='text' name='name' required><br><br>");
        out.println("Roll No: <input type='text' name='roll' required><br><br>");
        for (int i = 1; i <= 5; i++) {
            out.println("Marks " + i + ": <input type='number' name='m" + i + "' min='0' max='100' required><br><br>");
        }
        out.println("<input type='submit' value='Calculate'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String roll = req.getParameter("roll");

        int total = 0;
        int[] marks = new int[5];
        boolean parseError = false;

        for (int i = 0; i < 5; i++) {
            try {
                marks[i] = Integer.parseInt(req.getParameter("m" + (i + 1)));
                total += marks[i];
            } catch (NumberFormatException ex) {
                parseError = true;
            }
        }

        double percentage = (total / 5.0);
        String division;
        if (parseError) {
            division = "Invalid marks entered";
        } else if (percentage >= 60) {
            division = "First Division";
        } else if (percentage >= 45) {
            division = "Second Division";
        } else if (percentage >= 33) {
            division = "Third Division";
        } else {
            division = "Fail";
        }

        out.println("<!doctype html><html><head><meta charset='utf-8'><title>Result</title></head><body>");
        out.println("<h2>Result</h2>");
        out.println("<p><strong>Name:</strong> " + escape(name) + "</p>");
        out.println("<p><strong>Roll No:</strong> " + escape(roll) + "</p>");
        out.println("<p><strong>Marks:</strong><ul>");
        for (int i = 0; i < 5; i++) {
            out.println("<li>Subject " + (i + 1) + ": " + marks[i] + "</li>");
        }
        out.println("</ul></p>");
        out.println("<p><strong>Total:</strong> " + total + "</p>");
        out.println(String.format("<p><strong>Percentage:</strong> %.2f%%</p>", percentage));
        out.println("<p><strong>Division:</strong> " + division + "</p>");
        out.println("<p><a href='" + req.getContextPath() + "/bmi'>Back</a></p>");
        out.println("</body></html>");
    }

    // minimal HTML-escape to avoid basic injection
    private String escape(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#x27;");
    }
}