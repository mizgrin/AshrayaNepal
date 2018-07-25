<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Rooms</title>
</head>
<body>

<form:form method="POST" enctype="multipart/form-data"
			action=""
			modelAttribute="room">
<div>
 			<label >Photo no 1</label><input type="file" name="room1"><br /> 
			 			<label >Photo no 2</label><input type="file" name="room2"><br /> 
			 			<label >Photo no 3</label><input type="file" name="room3"><br /> 
			 			<label >Photo no 4</label><input type="file" name="room4"><br /> 
			
				
			<br>
			<form:button type="submit" class="btn btn-primary">Submit</form:button>
					</div>
			
		</form:form>

</body>
</html>