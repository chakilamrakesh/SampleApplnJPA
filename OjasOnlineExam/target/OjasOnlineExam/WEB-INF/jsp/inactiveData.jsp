<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Questions</title>

<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/animate.css">
<link href="../css/animate.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet" />


<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}
</style>
</head>
<body>

	<header id="header">
		<nav class="navbar navbar-default navbar-static-top" role="banner">
			<div class="container">
				<div class="navbar-header">
					<span><img src="../img/ojas.png" align="left" height="80px"
						width="250px"></span>
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">

						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="navbar-brand">
						<a href="index.jsp"><h1></h1></a>
					</div>
				</div>
				<div class="navbar-collapse collapse">
					<div class="menu">

						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation"><a href="/OjasOnlineExam/dashboard">Dashboard</a></li>

							<li><a href="getAllQuestions" class="active">View
									Questions </a></li>
							<li role="presentation"><a
								href="/OjasOnlineExam/getAllUsersByAdmin">Manage User</a></li>
							<li role="presentation"><a href="/OjasOnlineExam/reports">Report</a></li>
							<li role="presentation"><a
								href="/OjasOnlineExam/notification">Notifications</a></li>
							<li role="presentation"><a href="logout">Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!--/.container-->
		</nav>
		<!--/nav-->
	</header>

	
	<button style="color: black" ><a href="getAllQuestions?status=active">Active data</a></button>
	<br>
	<br>
	
	<!----- Inactive data form ----->
	
	<div id="inactiveDataForm">
		<form action="getQuestionsByTechnology" method="delete" align="center">
			<input type="text" placeholder="Search by technology"
				name="technology" style="color: black;" /> <input type="submit"
				style="color: black;" value="submit">
		</form>
		<br>
		<form action="deleteBatchQuestion" method="delete">
			<table border="1" align="center">
				<tr align="center">
					<th><input type="submit" value="Delete" style="color: black;"></th>
					<th><font color="black">Question</font></th>
					<th><font color="black">Option1</font></th>
					<th><font color="black">Option2</font></th>
					<th><font color="black">Option3</font></th>
					<th><font color="black">Option4</font></th>
					<th><font color="black">Correct Option</font></th>
					<th><font color="black">Technology</font></th>
					<th><font color="black">Question Type</font></th>
					<th><font color="black">Question Level</font></th>
					<th><font color="black">Edit/Active</font></th>
					<th><font color="black">Status</font></th>
				</tr>

				<c:forEach var="employee" items="${listEmployee}">
					<tr>
						<td><input type="checkbox" name="selected"
							value="${employee.id}"></td>

						<td align="center"><font color="red">${employee.question}</font></td>
						<td align="center"><font color="blue">${employee.option1}</font></td>
						<td align="center"><font color="blue">${employee.option2}</font></td>
						<td align="center"><font color="blue">${employee.option3}</font></td>
						<td align="center"><font color="blue">${employee.option4}</font></td>
						<td align="center"><font color="green">${employee.correctoption}</font></td>
						<td align="center"><font color="blue">${employee.technology}</font></td>
						<td align="center"><font color="blue">${employee.questiontype}</font></td>
						<td align="center"><font color="blue">${employee.questionlevel}</font></td>
						<td align="center">
							<a href="editQuestion?id=${employee.id}"><font color="green">Edit</font></a> 
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="changeStatus?id=${employee.id}"><font color="green">Active</font></a>
						</td>
						<td align="center"><font color="green">${employee.status}</font></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<footer>
		<div class="container">
			<div class="col-md-4 wow fadeInDown" data-wow-duration="1000ms"
				data-wow-delay="300ms">
				<h4>About Us</h4>
				<p>Hyderabad, INDIA Ojas Innovative Technologies</p>
				<div class="contact-info">
					<ul>
						<li><i class="fa fa-home fa"></i>Block C, Floor 9, MJR
							Magnifique, Raidurgam Hyderabad - 500008, Telangana</li>
						<li><i class="fa fa-phone fa"></i> +91 40 41430000</li>
						<li><i class="fa fa-envelope fa"></i> sales@ojas-it.com</li>
					</ul>
				</div>
			</div>

			<div class="col-md-4 wow fadeInDown" data-wow-duration="1000ms"
				data-wow-delay="900ms">
				<div class="">
					<h5>Ojas is now</h5>
					<div>
						<img src="../img/cmmi.jpg" height="150px" width="250px">
					</div>
				</div>
			</div>

			<div class="col-md-4 wow fadeInDown" data-wow-duration="1000ms"
				data-wow-delay="900ms">
				<div class="">
					<h5>ISO 9001:2015 Certified & ISO 27001:2013 Certified</h5>
					<div>
						<img src="../img/nasscomm-member1.png" height="150px"
							width="250px">
					</div>
				</div>
			</div>
		</div>
	</footer>


	<div class="sub-footer">
		<div class="container">
			<div class="col-md-12">
				<div class="copyright col-md-7">&copy; 2011-2018 Ojas
					Innovative Technologies. All Rights Reserved.</div>
				<div class="social-icon">
					<div class="col-md-4 col-md-offset-1">
						<ul class="social-network">
							<li><a href="#" class="fb tool-tip" title="Facebook"><i
									class="fa fa-facebook"></i></a></li>
							<li><a href="#" class="twitter tool-tip" title="Twitter"><i
									class="fa fa-twitter"></i></a></li>
							<li><a
								href="https://plus.google.com/+OjasInnovativeTechnologiesIndiaPvtLtd2017"
								class="gplus tool-tip" title="Google Plus"><i
									class="fa fa-google-plus"></i></a></li>
							<li><a
								href="https://www.linkedin.com/company/ojas-innovative-technologies/"
								class="linkedin tool-tip" title="Linkedin"><i
									class="fa fa-linkedin"></i></a></li>
							<li><a href="#" class="ytube tool-tip" title="You Tube"><i
									class="fa fa-youtube-play"></i></a></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- 	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script>
		wow = new WOW({}).init();
	</script>

</body>
</html>