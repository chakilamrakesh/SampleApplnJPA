<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Ojas Online Exam</title>

<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/animate.css">
<link href="../css/animate.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet" />
</head>
<body>
	<header id="header"> <nav
		class="navbar navbar-default navbar-static-top" role="banner">
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
					<li role="presentation"><a href="/OjasOnlineExam/dashboard"
						class="active">Dashboard</a></li>

					<li><a href="/OjasOnlineExam/examController/getAllQuestions">View
							Questions </a></li>
					<li role="presentation"><a
						href="/OjasOnlineExam/getAllUsersByAdmin">Manage User</a></li>
					<li role="presentation"><a href="/OjasOnlineExam/reports">Report</a></li>
					<li role="presentation"><a href="/OjasOnlineExam/notification">Notifications</a></li>
					<li role="presentation"><a href="/OjasOnlineExam/logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--/.container--> </nav> <!--/nav--> </header>

	<div class="content_div">
		<div align="center">
			<h1>New/Edit Questions</h1>
			<div class="container" style="height: 100px"></div>
			<table align="center">
				<h3>You have Updated your Details Successfully...</h3>

				<h3>Thanks You.....</h3>


				<h4>Please Click Here To continue....</h4>
			</table>

			<div class="col-md-11 text-right">
				<button class="btn btn-light ">
					<a href="/OjasOnlineExam/getAllUsersByAdmin" />Back</a>
				</button>
			</div>

			<div class="container" style="height: 100px"></div>
		</div>
	</div>
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
					<img src="../img/nasscomm-member1.png" height="150px" width="250px">
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

</body>
</html>