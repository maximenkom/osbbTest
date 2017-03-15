<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin's page</title>
</head>
 <ul class="nav navbar-nav navbar-right">
            <li><a href="/osbbTest/logout">Logout</a></li>
        </ul>
<body>
 ${welcome}<br>
      <span class="red-text text-darken-2">${message}</span> 
      
      <form method="POST" action="${contextPath}/deleteHouse" class="form-signin">
  <table class="striped" style="width: 60%"> 
        <thead>
          <tr >
              <th data-field="id">Id</th>
              <th data-field="adress">Adress</th>            
          </tr>
        </thead>
        <tbody>
        <c:forEach var="house" items="${housesList}">  
          <tr>
            <td style="width: 30%">${house.id}</td>
            <td style="width: 50%">${house.adress}</td>
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
           <td style="width: 20%"><button class="btn red"  type="submit" name="id" value="${house.id}"
            onclick="return confirm('Are you sure you want to delete this house?')"> 
                   <i class="small material-icons">delete</i></button></td>   
                   
            </c:forEach>      
          </tr>
 
        </tbody>
      </table>       
 </form>
 
 <form method="POST" action="${contextPath}/adminpage" class="form-signin">
    
        <h2 class="form-heading" style="font-size: 2.0rem">Add a house</h2>       
            
        <div class="row">
      	    	 <div class="input-field col s12">
            <input name="adress" type="text" class="form-control col s4" placeholder="Adress"
                   autofocus="true"/>
            	
     	 </div>   
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
           
        </div>

    </form>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css"> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>

</body>
</html>