<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserDetails Data</title>
</head>
<body>
	<h1>Users Details</h1>

	<table border="1">
		<tr>
			<th>UserID</th>
			<th>User Name</th>
			<th>Gender</th>
			<th>Technology</th>
			<th>Experience</th>
			<th>Qualification</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>UID</th>
			<th>DOB</th>
			<th>Address</th>
			<th>Password</th>
		</tr>

		<tr>
			<td><c:out value="${user.userId}" /></td>
			<td><c:out value="${user.userName}" /></td>
			<td><c:out value="${user.gender}" /></td>
			<td><c:out value="${user.technology}" /></td>
			<td><c:out value="${user.experience}" /></td>
			<td><c:out value="${user.qualification}" /></td>
			<td><c:out value="${user.email}" /></td>
			<td><c:out value="${user.mobile}" /></td>
			<td><c:out value="${user.uid}" /></td>
			<td><c:out value="${user.dob}" /></td>
			<td><c:out value="${user.address}" /></td>
			<td><c:out value="${user.password}" /></td>


			<td><a href="<c:url value="/delete/${user.userId}"/>">Delete
					User</a></td>
			<td><a href="<c:url value="/edit/${user.userId}"/>">Edit
					User</a></td>


		</tr>

	</table>

</body>
</html>
