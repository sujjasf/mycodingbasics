<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head><meta charset="utf-8"><title>BMI Form</title></head>
<body>
  <h1>BMI Calculator</h1>
  <form method="post" action="result.jsp">
    Name: <input type="text" name="name" required><br><br>
    Height (cm): <input type="number" name="height" min="1" step="0.1" required><br><br>
    Weight (kg): <input type="number" name="weight" min="0.1" step="0.1" required><br><br>
    <input type="submit" value="Calculate BMI">
  </form>
</body>
</html>
