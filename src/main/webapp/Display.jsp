<%@page import ="com.jsp.carmanegment.*" %>
<%@page import ="java.util.List" %>

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
       List<Car> cars=(List) request.getAttribute("carList");
      %>
      <h1 style="font-family: sans-serif; color: red;">CARS-TABLE</h1>
      <table border="3px" style="display: flex; align-items: center; justify-content: center;">
       <tr>
           <th>Car id</th>
           <th>Car Model</th>
           <th>Car brand</th>
           <th>Car Price</th>
           <th>UPDATE</th>
           <th>DELETE</th>
      
       </tr>      
       <%for(Car car:cars){ %>
       <tr>
          <td><%=car.getCarId() %></td>
          <td><%=car.getCarModel() %></td>
          <td><%=car.getCarBrand() %></td>
          <td><%=car.getCarPrice() %></td>
          <td> <a href="UpdateCar?carId=<%=car.getCarId()%>">UPDATE</a></td>
          <td> <a href="DeleteCar?carId=<%=car.getCarId()%>">DELETE</a></td>
      </tr>
      <%
       }
      %>
      </table>
</body>
</html>