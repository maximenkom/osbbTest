<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>
    
</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading" style="font-size: 2.0rem">Create your account</h2>        
             
                <form:input type="text" path="firstname" class="form-control" placeholder="Firstname"
                            autofocus="true"></form:input>                
                    
                <form:input type="text" path="lastname" class="form-control" placeholder="Lastname" autofocus="true"></form:input>
          
                <form:input type="email" path="email" class="form-control" placeholder="Email" autofocus="true"></form:input>             
                 
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>               
            
                <form:input type="hidden" path="enabled" class="form-control" value="true"   ></form:input>                  
        
                <form:input type="number" path="roomNumber" class="form-control" placeholder="Room" ></form:input>
               
             
       
 <form:select class="browser-default" path="houseId">
    <option value="" disabled selected>Choose your house</option>
     <c:forEach var="house" items="${houses}">
		   
	 <option  value="${house.id}" >${house.id} ${house.adress}</option>
		    </c:forEach>   
  </form:select>
          <br>	
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
	    </form:form>
	
	</div>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css"> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
</body>
</html>