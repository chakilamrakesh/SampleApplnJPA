<%@ page language="java"
	contentType="text/html;  import=java.io.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Day - HTML Bootstrap Template</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.css">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
</head>
<body>

	<header id="header">
		<nav class="navbar navbar-default navbar-static-top" role="banner">
			<div class="container">
				<div class="navbar-header">
					<span><img src="img/ojas.png" align="left" height="80px"
						width="150px"></span>
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
							<li role="presentation"><a href="dashboard" class="active">Dashboard</a></li>
							<li role="presentation"><a
								href="examController/getAllQuestions">View Questions</a></li>
							<li role="presentation"><a href="getAllUsersByAdmin">MANAGE
									USER</a></li>
							<li role="presentation"><a href="reports">Report</a></li>
							<li role="presentation"><a href="getAllNotifications">Notifications</a></li>
							<li role="presentation"><a href="logout">Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
	</header>
	<br><br>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of notifications</h2>
			</caption>
			<tr>
				<th><font color="black">ID</font></th>
				<th><font color="black">Name</font></th>
				<th><font color="black">message</font></th>
			</tr>
			<c:forEach var="notify" items="${notificationList}">
				<tr>
					<td><font color="black"><c:out value="${notify.id}" /></font></td>
					<td><font color="black"><c:out value="${notify.userName}" /></font></td>
					<td><font color="black"><c:out value="${notify.msg}" /></font></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<br>
	<br><br><br><br>
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
					<h4>Ojas is now</h4>
					<div>
						<img src="img/cmmi.jpg" height="200px" width="250px">
					</div>
				</div>
			</div>

			<div class="col-md-4 wow fadeInDown" data-wow-duration="1000ms"
				data-wow-delay="900ms">
				<div class="">
					<h4>ISO 9001:2015 Certified & ISO 27001:2013 Certified</h4>
					<div>
						<img src="img/nasscomm-member1.png" height="200px" width="250px">
					</div>
				</div>
			</div>
		</div>
	</footer>


	<div class="sub-footer">
		<div class="container">
			<div class="social-icon">
				<div class="col-md-4">
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

			<div class="col-md-4 col-md-offset-4">
				<div class="copyright">
					&copy; 2011-2018 Ojas Innovative Technologies. All Rights Reserved.
					<div class="credits">

						<a href="https://bootstrapmade.com/"></a>
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