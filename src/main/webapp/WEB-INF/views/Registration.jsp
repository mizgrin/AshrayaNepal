<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 bransitional//EN" "http://www.w3.org/br/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>

</head>
<body>

	<div class="container">
		<form:form method="POST"
			action="${pageContext.request.contextPath}/registration"
			modelAttribute="userForm">
			<div class="form-group">
				<form:input type="hidden" path="userId" name="userId"
					value="${userId}" />
			</div>
			<div class="form-group">
				<form:label path="userName">UserName</form:label>
				<form:input type="text" class="form-control" name="userName"
					path="userName" value="${userName}" placeholder="EnterName"></form:input>
			</div>

			<div class="form-group">
				<form:label path="userEmail">Email</form:label>
				<form:input type="email" class="form-control" id="userEmail"
					name="userEmail" path="userEmail" value="${userEmail}"
					placeholder="Enter Valid Email"></form:input>
			</div>
			<div class="form-group">


				<form:label path="userPassword">Password</form:label>
				<form:input type="password" class="form-control" name="userPassword"
					path="userPassword" value="${userPassword }"
					placeholder="Enter your password"></form:input>

			</div>
			<div class="form-group">
				<form:label path="userPasswordConfirm">Password Confirm</form:label>
				<form:input type="password" class="form-control"
					name="userPasswordConfirm" path="userPasswordConfirm"
					value="${userPasswordConfirm }" placeholder=""></form:input>
			</div>

			<div class="form-group">
				<form:label for="${roles}" path="roles">
					<b>Role</b>
				</form:label>
				<select name="roles" class="form-control">
					<c:forEach var="roleDetail" items="${role}">

						<option value=${roleDetail.id}>${roleDetail.name}</option>
					</c:forEach>
				</select>

			</div>
			<!-- <div>
<select name="role">Role
<option value="Admin">Admin	</option>
<option value="Host">Host</option>
<option value=" Guest">Guest
</option>
</select>
</div> -->
			<br>
			<br>
			<form:button type="submit" class="btn btn-primary">Submit</form:button>
		</form:form>
	</div>


</body>
</html>