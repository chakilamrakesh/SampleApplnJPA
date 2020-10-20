<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>UserDetails Data</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.css">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/upload.js"></script>

</head>
<body>

	<%@ include file="adminHeader.jsp"%>

	<div class="container" style="height: 50px"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<h1 style="color: #1a75ff">Users Details</h1>
			</div>


		</div>

		<div class="table-responsive ">
			<table class="table table-bordered table table-hover">
				<tr style="background-color: #0080ff">

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
					<th colspan="2">Manage Users</th>
				</tr>
				<c:forEach var="user" items="${userlist}">
					<tr style="color: #1a75ff">
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

				</c:forEach>

			</table>
		</div>

		<div class="col-md-11 text-right">
			<button class="btn btn-light ">
				<a href="getAllUsersByAdmin" />Back</a>
			</button>
		</div>
	</div>
	</br>
	</br>
	</br>


	<%@ include file="footer.jsp"%>
</body>
</html>