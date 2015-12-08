<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products Details</title>
</head>
<body>
	<h1>Product Details</h1>
	
	<h3>${message}</h3>
	
	<table border="1px">
		<tr><th>Number</th><th>Name</th><th>Price</th>
		<sec:authorize ifAnyGranted="ROLE_ADMIN">
			<th><a href="showForm.action">Add New Product</a></th>
		</sec:authorize>
		</tr>
		<c:forEach var="p" items="${products}">
			<tr>
				<td>${p.productId}</td>
				<td>${p.name}</td>
				<td>${p.unitPrice}</td>
				<sec:authorize ifAnyGranted="ROLE_ADMIN">
					<td><a href="delete.action?pid=${p.productId}">Delete</a></td>
				</sec:authorize> 
			</tr>
		</c:forEach>
	</table>
</body>
</html>