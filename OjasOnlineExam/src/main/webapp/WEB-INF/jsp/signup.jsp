<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

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
<link href="css/signup.css" rel="stylesheet">

<script>
	function register(event) {

		event.preventDefault(); // this will prevent the submit event.
		firstName = document.getElementById("firstName").value;
		document.getElementById("errName").innerHTML = "";
		var nameRegExp = /^[a-zA-Z ]{2,30}$/;

		experience = document.getElementById("experience").value;
		document.getElementById("errExperience").innerHTML = "";

		mobile = document.getElementById('mobile').value;
		document.getElementById("errMobile").innerHTML = "";
		var mobileregex = /^(\+\d{1,3}[- ]?)?\d{10}$/;

		aadhar = document.getElementById('aadhar').value;
		document.getElementById("errAadhar").innerHTML = "";
		//var aadharRegExp = /^\d{4}\s\d{4}\s\d{4}$/;
		var aadharRegExp = /^(\+\d{1,3}[- ]?)?\d{12}$/;

		email = document.getElementById("email").value;
		document.getElementById("errEmail").innerHTML = "";
		//var emailRegEx = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/;
		var emailRegEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

		gender = document.getElementById("gender").checked;
		document.getElementById("errGender").innerHTML = "";

		address = document.getElementById("address").value;
		document.getElementById("errAddress").innerHTML = "";

		dob = document.getElementById("dateOfBirth").value;
		document.getElementById("errDateOfBirth").innerHTML = "";
		//var dateRegEx = /^\d{2}([./-])\d{2}\1\d{4}$/;
		var dateRegEx = /^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$/;

		qualification = document.getElementById("qualification").value;
		document.getElementById("errQualification").innerHTML = "";

		technology = document.getElementById("technology").value;
		document.getElementById("errTechnology").innerHTML = "";

		var flag = 0;

		if (firstName == "") {

			flag = 1;

			document.getElementById("errName").innerHTML = "Please Enter name";

		} else if (!nameRegExp.test(firstName)) {

			flag = 1;

			document.getElementById("errName").innerHTML = "Please enter valid  name";

		}
		if (qualification == "") {

			flag = 1;

			document.getElementById("errQualification").innerHTML = "Please Enter qualification";

		}
		if (technology == "") {

			flag = 1;

			document.getElementById("errTechnology").innerHTML = "Please Enter valid qualification";

		}
		if (experience == "") {

			flag = 1;

			document.getElementById("errExperience").innerHTML = "Please Enter experience";

		}

		if (email == "") {

			flag = 1;

			document.getElementById("errEmail").innerHTML = "Please Enter EmailID";

		} else if (!emailRegEx.test(email)) {

			flag = 1;

			document.getElementById("errEmail").innerHTML = "Please enter Valid  EmailID";

		}

		if (gender == "") {

			flag = 1;

			document.getElementById("errGender").innerHTML = "Please Enter Gender";

		}

		if (address == "") {

			flag = 1;

			document.getElementById("errAddress").innerHTML = "Please Enter address";

		}

		if (dob == "") {

			flag = 1;

			document.getElementById("errDateOfBirth").innerHTML = "Please Enter Date";

		}
		if (mobile == "") {

			flag = 1;

			document.getElementById("errMobile").innerHTML = "Please Enter mobile number";

		} else if (!mobileregex.test(mobile)) {

			document.getElementById("errMobile").innerHTML = "Please Enter Valid  mobile number";

		}
		if (aadhar == "") {

			flag = 1;

			document.getElementById("errAadhar").innerHTML = "Please Enter aadhar number";

		} else if (!aadharRegExp.test(aadhar)) {

			document.getElementById("errAadhar").innerHTML = "Please Enter Valid  aadhar number";

		}

		if (flag == 0) {

			location.reload();
			// return true;

		} else {

			return false;

		}
	}
</script>
</head>

<body>

	<%@include file="header.jsp"%>

	<div class="container" align="center" style="color: black">
		<!-- onSubmit=" return register(event)" -->
		<form:form name="registerForm" action="register"
			class="form-horizontal" role="form" method="post"
			modelAttribute="userRegForm">

			<h2 align="justify">Registration Form</h2>
			<div class="form-group" align="center">
				<label for="firstName" class="col-sm-3 control-label">Full
					Name</label>
				<div class="col-sm-9">

					<form:input type="text" name="firstName" id="firstName"
						placeholder="FullName" path="userName" class="form-control"
						required="autofocus" />
					<span id="errName" style="color: red"></span>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">Email</label>
				<div class="col-sm-9">
					<form:input type="email" name="email" id="email"
						placeholder="Email" path="email" class="form-control"
						required="autofocus" />
					<span id="errEmail" style="color: red"></span>
				</div>
			</div>
			<div class="form-group">
				<label for="mobile" class="col-sm-3 control-label">Mobile</label>
				<div class="col-sm-9">
					<form:input type="number" name="mobile" id="mobile"
						placeholder="Mobile" path="mobile" class="form-control"
						required="autofocus" />
					<span id="errMobile" style="color: red"></span>
				</div>
			</div>

			<div class="form-group">
				<label for="aadhar" class="col-sm-3 control-label">Aadhar
					Number</label>
				<div class="col-sm-9">
					<form:input type="number" name="aadhar" id="aadhar" path="uid"
						placeholder="Aadhar" class="form-control" required="autofocus" />
					<span id="errAadhar" style="color: red"></span>
					<!-- pattern="[0-9]" -->
				</div>
			</div>

			<div class="form-group">
				<label for="birthDate" class="col-sm-3 control-label">Date
					of Birth</label>
				<div class="col-sm-9">
					<form:input type="date" name="dateOfBirth" id="dateOfBirth"
						path="dob" placeholder="DateOfBirth" class="form-control"
						required="autofocus" />
					<span id="errDateOfBirth" style="color: red"></span>
				</div>
			</div>

			<div class="form-group">
				<label for="qualification" class="col-sm-3 control-label">Qualification</label>
				<div class="col-sm-9">
					<form:select id="qualification" path="qualification"
						class="form-control mand" required="autofocus">
						<option>B.Tech</option>
						<option>MCA</option>
						<option>M.Tech</option>
						<option>B.Com</option>
					</form:select>
					<span id="errQualification" style="color: red"></span>
				</div>
			</div>

			<div class="form-group">
				<label for="Experience Level" class="col-sm-3 control-label">Experience
					Level</label>
				<div class="col-sm-9">
					<form:input type="text" name="experience" id="experience"
						placeholder="Experience Level" path="experience"
						class="form-control" required="autofocus" />
					<span id="errExperience" style="color: red"></span>
				</div>
			</div>

			<div class="form-group">
				<label for="technology" class="col-sm-3 control-label">Technology</label>
				<div class="col-sm-9">
					<form:select id="technology" multiple="multiple" path="technology"
						class="form-control mand" required="autofocus">
						<option>Java</option>
						<option>DotNet</option>
						<option>Idm</option>
						<option>Python</option>
						<option>Java Script</option>
						<option>PhP</option>
					</form:select>
					<span id="errTechnology" style="color: red"></span>
				</div>
			</div>
			<!-- /.form-group -->
			<div class="form-group">
				<label class="control-label col-sm-3">Gender</label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-4">
							<label class="radio-inline"> <form:radiobutton
									name="gender" path="gender" id="gender" value="female" />Female
								<form:radiobutton name="gender" path="gender" id="gender"
									value="male" />Male <span id="errGender" style="color: red"></span>
							</label>
						</div>


					</div>
				</div>
			</div>
			<!-- /.form-group -->
			<div class="form-group">
				<label for="address" class="col-sm-3 control-label">Address</label>
				<div class="col-sm-9">
					<form:textarea class="form-control" rows="5" id="address"
						path="address" required="autofocus"></form:textarea>
					<span id="errAddress" style="color: red; resize: none;"></span>
				</div>
			</div>
			<!-- /.form-group -->
			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<div class="checkbox">
						<label> <input type="checkbox">I accept <a
							href="#">terms</a>
						</label>
					</div>
				</div>
			</div>
			<!-- /.form-group -->
			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</div>
		</form:form>
	</div>

	<hr>

	<%@include file="footer.jsp"%>

	<script type="text/javascript">
		document.getElementById("myButton").onclick = function() {
			location.href = "/signup.jsp";
		};
	</script>
</body>

</html>
