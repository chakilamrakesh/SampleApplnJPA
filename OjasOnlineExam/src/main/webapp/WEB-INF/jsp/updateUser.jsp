<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editing User Details</title>
</head>
<body>
	<h2>Edit User Data</h2>
	<form:form method="POST" action="save" modelAttribute="data">

		<table>
			<tr>
				<td>User Id</td>
				<td><input type="text" name="userId"
					value=<%=request.getAttribute("id")%> readonly="true"></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender"></td>
			</tr>
			<tr>
				<td>Technology</td>
				<td><input type="text" name="technology"></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><input type="text" name="experience"></td>
			</tr>
			<tr>
				<td>Qualification</td>
				<td><input type="text" name="qualification"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td>UID</td>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><input type="text" name="dob"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>

				<td colspan="2"><input type="submit" value="submit"></td>

			</tr>

		</table>



	</form:form>