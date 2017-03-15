<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager's page</title>
</head>
 <ul class="nav navbar-nav navbar-right">
            <li><a href="/osbbTest/logout">Logout</a></li>
        </ul>
<body>
Welcome dear manager ${name}<br>

 <table class="striped" style="width: 60%"> 
   
        <thead>
          <tr >
              <th data-field="firstname">firstname</th>
              <th data-field="lastname">lastname</th>        
               <th data-field="email">email</th> 
               <th data-field="room">room</th> 
          </tr>
        </thead>
        <tbody> 
         <c:forEach var="user" items="${users}">  
          <tr>
            <td style="width: 20%">${user.firstname}</td>
            <td style="width: 40%">${user.lastname}</td>
                 <td style="width: 30%">${user.email}</td>
                   <td style="width: 10%">${user.roomNumber}</td>
                   
            </c:forEach>  
          </tr>
 
        </tbody>
      </table>       


   

<%--  <c:forEach var="user" items="${users}">
    ${user}<br>
   <td>${users.lastName}</td><td>${users.id} </td>  
     
   </c:forEach>  --%>
   
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css"> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
</body>
</html>