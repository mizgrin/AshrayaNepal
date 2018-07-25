<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available rooms</title>
</head>
<body>

                    <table id="dataTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                        <thead>
      <tr>
     
     		<th>S.N</th>
     	<th>Name</th>
     	
     	<th>Address</th>
     	
     	<th>Available Room</th>
     	<th>Contact number</th>
     	<th>Family type</th>
     	<th>Email id</th>
     <th>Owner photo</th>
  		<th>Room pictures</th>
      </tr>
    </thead>
                        <tfoot>
                         <tr>
     
     	<th>S.N</th>
     	<th>Name</th>
     	<th>Address</th>
     	
     	<th>Available Room</th>
     	<th>Contact number</th>
     	<th>Family type</th>
     	<th>Email id</th>
     <th>Owner photo</th>
  		<th>Room pictures</th>
      </tr>
                        </tfoot>
                        <tbody>
                           <c:if test="${not empty hostlists}">
     	<c:forEach items="${hostlists}" var="hostlist" varStatus="count">
     	${hostlist.hostId }
     	  
     	<tr>
     	<td>${hostlist.hostId}</td>
     	<td>
     	${hostlist.hostName}
     	</td>
     <td>
     	${hostlist.address}
     	
     	</td>
     	<td>
     	${hostlist.availableRoom}
     	
     	</td>
     	<td>
     	${hostlist.familyType}
     	</td>
     	<%-- <td>
     	${hostlist.contact}
     	</td> --%>
     	<td>
     	
     	<img alt="photo" src="${pageContext.request.contextPath}/resources/upload/${hostlist.photo}" width="100" height="100"></td>
     	</c:forEach> </c:if>
     	</tbody>
  </table>
</body>
</html>