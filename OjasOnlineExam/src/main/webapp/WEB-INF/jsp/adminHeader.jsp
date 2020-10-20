<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Header</title>
</head>
<body>

	<header id="header"> <nav
		class="navbar navbar-default navbar-static-top" role="banner">
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
					<li role="presentation"><a href="dashboard">Dashboard</a></li>
					<li role="presentation"><a
						href="/OjasOnlineExam/examController/getAllQuestions">View
							Questions</a></li>
					<li role="presentation"><a href="getAllUsersByAdmin">MANAGE
							USER</a></li>
					<li role="presentation"><a href="reports">Report</a></li>
					<li role="presentation"><a href="getAllNotifications">Notifications</a></li>
					<li role="presentation"><a href="index.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--/.container--> </nav> <!--/nav--> </header>
</body>
</html>
