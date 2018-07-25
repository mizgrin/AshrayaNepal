<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 bransitional//EN" "http://www.w3.org/br/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>

</head>
<body > --%>
${msg}
<div class="container">

<form  method="POST" action="${pageContext.request.contextPath }/login"  >
<c:if test="${not empty error}"><div>${error}</div></c:if>
	<c:if test="${not empty message}"><div>${message}</div></c:if>
  <div class="form-group">
  ${error}
  
    <label >userName</label>
    <input type="text" class="form-control" name="username"  placeholder="Enter username"></input>
  </div>
  <div class="form-group">
    <label  path="userPassword">Password</label>
    <input type="password" class="form-control"  name ="password"   placeholder="Enter Password"></input>
  </div>
 	    
  
  <button type="submit" class="btn btn-primary">Login</button>
</form>
</div>
  <div>
</div>

</body>
</html>