<%@page import="com.jsp.carmanegment.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%
          Car car=(Car) request.getAttribute("carId");
     %>
      <form action="saveUpdatedCar" method="post">
        <input type="number" name="carId" value="<%=car.getCarId()%>" readonly="readonly"><br><br>
        <input type="text" name="carModel" value="<%=car.getCarModel()%>" ><br><br>
        <input type="text" name="carBrand" value="<%=car.getCarBrand()%>" ><br><br>
         <input type="number" name="carPrice" value="<%=car.getCarPrice()%>"><br><br>
         <input type="submit" value="UPDATE" style="background: blue; color: yellow;">
      </form>
</body>
</html>