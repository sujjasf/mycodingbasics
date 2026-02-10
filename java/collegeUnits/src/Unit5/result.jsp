<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String name = request.getParameter("name");
    String hStr = request.getParameter("height");
    String wStr = request.getParameter("weight");

    double heightCm = 0, weightKg = 0, bmi = 0;
    String error = null;
    try {
        heightCm = Double.parseDouble(hStr);
        weightKg = Double.parseDouble(wStr);
        double heightM = heightCm / 100.0;
        if (heightM <= 0) throw new NumberFormatException();
        bmi = weightKg / (heightM * heightM);
    } catch (Exception e) {
        error = "Invalid numeric input for height or weight.";
    }

    String category = "";
    if (error == null) {
        if (bmi < 18.5) category = "Underweight";
        else if (bmi < 25) category = "Normal";
        else if (bmi < 30) category = "Overweight";
        else category = "Obese";
    }

    // basic escape
    String esc = (name==null) ? "" : name.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;").replace("\"","&quot;");
%>
<!doctype html>
<html>
<head><meta charset="utf-8"><title>BMI Result</title></head>
<body>
  <h1>BMI Result</h1>
  <% if (error != null) { %>
    <p style="color:red;"><%= error %></p>
  <% } else { %>
    <p><strong>Name:</strong> <%= esc %></p>
    <p><strong>BMI:</strong> <%= String.format("%.2f", bmi) %></p>
    <p><strong>Category:</strong> <%= category %></p>
  <% } %>
  <p><a href="bsd.jsp">Back</a></p>
</body>
</html>
