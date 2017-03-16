<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
 <ul class="nav navbar-nav navbar-right">
            <li><a href="/osbbTest/logout">Logout</a></li>
        </ul>
<body>
Welcome ${name}

 <table class="striped" style="width: 60%"> 
        
        <tbody>       
          <tr>
            <td style="width: 30%">${firstname}</td>
            <td style="width: 40%">${lastname}</td>
            <td style="width: 30%">${email}</td>   
           </tr>
           </table>
           
              <form method="POST" action="${contextPath}/counter">
           <table  style="width: 60%">         
            <c:forEach var="counter" items="${countersList}">  
           <tr>      
            <td style="width: 15%">${counter.id}  </td>
       <td style="width: 15%">Counter for  ${counter.serviceType.serviceName}  </td>
        <td style="width: 30%">previous amount  ${counter.amount}  </td>
         <td style="width: 15%">rate  ${counter.serviceType.rate}  </td>
          <td style="width: 15%">  <input name="amount" type="number" class="form-control col s4" placeholder="actual amount"
                   autofocus="true"/>  </td>
                    
                    <td> <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="hidden" name="id" value="${counter.id}" />
                     <button class="btn btn-lg btn-primary btn-block" type="submit">Send</button></td>
                    
           </tr>
             </c:forEach>
        </tbody>
      </table>         
 </form>
      <div class="text-center" style="font-size: 1.2rem; color:red">${payment} </div>             
            
  

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css"> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
</body>
</html>