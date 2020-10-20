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
<script>
	function validateForm() {
		var x = document.forms["myForm"]["fname"].value;
		if (x == "") {
			alert("Name must be filled out");
			return false;
		}
	}
</script>
</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container" style="height: 100px"></div>


	<div class="content_div">
		<div align="center">
			<h1>Registered...</h1>

			<table align="center">
				<h3>You have Registered Successfully...</h3>

				<h3>Thanks You.....</h3>

				<br>
				<h4>Please Click Below To Login</h4>


				<div class="col-md-11 text-right">
					<button class="btn btn-light ">
						<a href="loginPage" />LOGIN HERE</a>
					</button>
				</div>

			</table>


			<div class="container" style="height: 100px"></div>

			<%@include file="footer.jsp"%>
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




