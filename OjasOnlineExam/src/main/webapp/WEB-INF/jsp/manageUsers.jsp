<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Ojas Online Exam</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.css">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />

<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<style>
table, th, td {
	border: 2px solid powderblue;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: left;
}

p {
	border: 1px solid powderblue;
}
</style>
</head>

<body>
	<%@include file="adminHeader.jsp"%>
	<!--/header-->
	<div class="container" style="height: 100px"></div>

	<div class="container" style="color: black">

		<div>
			<div>
				<table>
					<caption>
						<b>User Details</b>
					</caption>
					<tr>
						<th bgcolor="white" align="center">UserId</th>
						<th>User Name</th>
						<th>Gender</th>
						<th>Technology</th>
						<th>Experience</th>
						<th>Qualification</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>UID</th>
						<th>Address</th>
						<th>DOB</th>
						<th>Role</th>
						<th>Update</th>
						<div colspan="2">
							<th>Manage Users</th>
						</div>


					</tr>
					<c:forEach var="user" items="${users}">
						<tr>
							<td bgcolor="white" align="center"><font color="red"><c:out
										value="${user.userId}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.userName}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.gender}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.technology}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.experience}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.qualification}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.email}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.mobile}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.uid}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.address}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.password}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.dob}" /></font></td>
							<td bgcolor="white" align="center"><font color="blue"><c:out
										value="${user.role}" /></font></td>

							<td bgcolor="lightblue" align="center"><a
								href="<c:url value="delete/${user.userId}"/>"><font
									color="blue">Delete User</font></a></td>
							<td bgcolor="lightblue" align="center"><a
								href="<c:url value="edit/${user.userId}"/>"><font
									color="blue">Edit User</font></a></td>


						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>


	<hr>


	<div class="container" style="height: 100px"></div>

	<%@include file="footer.jsp"%>
</body>

</html>
