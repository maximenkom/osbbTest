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

    <title>Login page</title> 

</head>

<body>

<div class="container">

    <form method="POST" action="${contextPath}/login" class="form-signin">
     <span class="red-text text-darken-2">${error}</span>
        <h2 class="form-heading" style="font-size: 2.0rem">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>            
  
            
        <div class="row">
      	    	 <div class="input-field col s12">
            <input name="username" type="text" class="form-control col s4" placeholder="Login"
                   autofocus="true"/>
            	 </div>
     	 </div>     
                   
         <div class="row">
      	    	 <div class="input-field col s12">          
            <input name="password" type="password" class="form-control col s4" placeholder="Password"/> 
      	 </div>
     			 </div>    
           
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center" style="font-size: 1.2rem"><a href="${contextPath}/registration">Registration</a></h4>
        </div>

    </form>

</div>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css"> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
</body>
</html>