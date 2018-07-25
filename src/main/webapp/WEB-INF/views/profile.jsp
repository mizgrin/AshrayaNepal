<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<body >
<div>

  	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
<h1>Name==>${host.hostName}</h1><br>

Address::>${host.address }<br>
Room Available==>${host.availableRoom })<br>
<hr>
Family type=>${host.familyType }<br>
<hr>


<h2>Photo</h2>==><img alt="photo" src="${pageContext.request.contextPath}/resources/upload/${host.photo}">

<%-- <a href="${pageContext.request.contextPath}/updatehostdetail/${host.userName}"><button> Edit</button></a>
 --%>
  <a href="${pageContext.request.contextPath}/rooms"><button>Add room photos</button></a>

</div>
</body>
</html>