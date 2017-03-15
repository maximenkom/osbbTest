<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
 
        </tbody>
      </table>       

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css"> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
</body>
</html>