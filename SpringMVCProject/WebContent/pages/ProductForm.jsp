<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Form</title>
</head>
<body>
	<h2> Product Form</h2>
	<sec:authorize ifNotGranted="ROLE_ADMIN">
		<h2>You do not have privileges to perform this operation. Please contact Admin</h2>
	</sec:authorize>
	<sec:authorize ifAnyGranted="ROLE_ADMIN">
	<sf:form action="register.action" method="POST" modelAttribute="pForm">
		<table>
			<tr>
				<td>Number :</td>
				<td><sf:input path="productId"/></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><sf:input path="name"/></td>
			</tr>
			<tr>
				<td>Unit Price :</td>
				<td><sf:input path="unitPrice"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"/> </td>
				<td><input type="reset"/> </td>
		</table>
	</sf:form>
	</sec:authorize>
</body>
</html>