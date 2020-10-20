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
	<div class="container" style="color: black">
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Login</h2>
					<p>Please enter your email and password</p>
				</div>


				<form:form id="loginForm" name="loginForm" action="userLoginPage"
					onsubmit="return validateForm()" method="post" class="form-signin"
					role="form" modelAttribute="loginDetails">
</body>

<div class="form-group">

	<form:input type="text" name="email" id="email" path="email"
		class="form-control mand" placeholder="Email address"
		required="autofocus" />
</div>
<div class="form-group">

	<form:input type="password" name="password" id="password"
		path="password" class="form-control disable mand" required="autofocus"
		placeholder="Password" />

</div>


<td align="center"><input type="submit" value="Login" /></td>
<div class="container" style="height: 20px"></div>
<div class="forgot">
	Sign Up! <a href="regForm"><font color="light blue">Register
			here...</font></a>
</div>

</form:form>

</div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>Choose the options</h4>
			</div>
			<div class="modal-body">
				<label>Technology</label> <select class="form-control" name="sort">
					<option>Java</option>
					<option>.Net</option>
					<option>IDM</option>
					<option>Service Now</option>
				</select> <label>Exprience</label> <select class="form-control" name="sort">
					<option>Fresher</option>
					<option>1-2 Years</option>
					<option>2-3 Years</option>
					<option>3-5 Years</option>
					<option>5+ Years</option>
				</select>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary"
					onclick="location.href='instruction.html'">Submit</button>
			</div>
		</div>

	</div>
</div>


</div>
<hr>

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




