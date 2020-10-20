<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.css">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>

<%@include file="header.jsp" %>
	
	<input type="text" placeholder="Search by technology"/>
	<form action="deleteBatchQuestion" method="delete">
	<table border="1">
		<th><input type="submit" value="Delete"></th>
		<th>Question</th>
		<th>Option1</th>
		<th>Option2</th>
		<th>Option3</th>
		<th>Option4</th>
		<th>Correct Option</th>
		<th>Technology</th>

		<c:forEach var="employee" items="${listEmployee}">
			<tr>
				<td><input type="checkbox" name="selected" value="${employee.id}"> </td>
				
				<td>${employee.question}</td>
				<td>${employee.option1}</td>
				<td>${employee.option2}</td>
				<td>${employee.option3}</td>
				<td>${employee.option4}</td>
				<td>${employee.correctoption}</td>
				<td>${employee.technology}</td>
				<td><a href="editQuestion?id=${employee.id}">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="deleteQuestionId?id=${employee.id}">Delete</a></td>

			</tr>
		</c:forEach>
		<!-- <tr> <a href="admin">Back</a></tr> -->
	</table>
	</form>
	<button onclick="alert('Which type of questions you want to add?')"><a href="questionsForm">Add Question</a></button>
	<hr>
	<%@include file="footer.jsp" %>
	<script type="text/javascript">
		function login() {
			var flag = document.getElementById("checkbox").checked;

			if (flag == true) {
				location.href = "adminHome.html";
			}
		}
	</script>
</body>
</html>




