<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 bransitional//EN" "http://www.w3.org/br/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>

</head>
<body>
 --%>
	<div class="container">
		<form:form method="POST" enctype="multipart/form-data"
			action="${pageContext.request.contextPath}/hostdetail"
			modelAttribute="hostDetail">
		<div class="form-group">
				<form:input type="hidden" path="hostId" name="hostId"
					value="${hostId}" />
			</div>
			<div class="form-group">
				
				<form:label path="hostName">HostName</form:label>
				
				 <form:input type="text" class="form-control" name="hostName"
					path="hostName" value="${hostName}"
					placeholder="Enter your full Name"></form:input>
			</div>

			<div class="form-group">
				<form:label path="address">Address</form:label>
				<form:input type="address" class="form-control" id="address"
					name="address" path="address" value="${address}"
					placeholder="Enter your Address Detail"></form:input>
			</div>
			<div>

				<label > Family type</label>
				<select name="familyType" class="form-control">

					<option value="Joint Family">Joint Family</option>
					<option value="Singular Family">Singular Family</option>
				</select>

			</div>
			<br>

			<div>

				<label > No. of Rooms Available</label>
				<select name="availableRoom" class="form-control">

					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select>

			</div>
			<div>
 			<label >Owner Photo</label><input type="file" name="photo"><br /> 
			
		</div>
				
			<br>
			<form:button type="submit" class="btn btn-primary">Submit</form:button>
		</form:form>
	</div>
	

<!-- </body>
</html> -->