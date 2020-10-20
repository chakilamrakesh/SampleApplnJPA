<!DOCTYPE html>
<html lang="en">

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
<!-- =======================================================
    Theme Name: Day
    Theme URL: https://bootstrapmade.com/day-multipurpose-html-template-for-free/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<body>

	<%@include file="\WEB-INF\jsp\header.jsp"%>
	
	

	<div class="slider">
		<div id="about-slider">
			<div id="carousel-slider" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators visible-xs">
					<li data-target="#carousel-slider" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-slider" data-slide-to="1"></li>
					<li data-target="#carousel-slider" data-slide-to="2"></li>
				</ol>

				<div class="carousel-inner">
					<div class="item active">
						<img src="img/slide.jpg" class="img-responsive" alt="">
						<div class="carousel-caption">
							<div class="wow fadeInUp" data-wow-offset="0"
								data-wow-delay="0.3s">
								<h2>
									<span>Ojas Innovative Technologies</span>
								</h2>
							</div>
							<div class="col-md-10 col-md-offset-1">
								<div class="wow fadeInUp" data-wow-offset="0"
									data-wow-delay="0.6s">
									<p>Online Examination</p>
								</div>
							</div>
							<div class="wow fadeInUp" data-wow-offset="0"
								data-wow-delay="0.9s">
								<form class="form-inline"`>
									<div class="form-group">
										<!-- <button type="livedemo" name="btn_signUp" class="btn btn-primary btn-lg"
											required="required" onclick="window.location= 'signup.html';">Sign up</button> -->
										<button type="livedemo">
											<a href="regForm">Sign Up</a>
										</button>

									</div>
									<div class="form-group">
										<!-- <button type="getnow" name="" class="btn btn-primary btn-lg"
											required="required">Login</button> -->
										<button type="livedemo">
											<a href="loginPage">Login</a>
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>

					<div class="item">
						<img src="img/slide.jpg" class="img-responsive" alt="">
						<div class="carousel-caption">
							<div class="wow fadeInUp" data-wow-offset="0"
								data-wow-delay="1.0s">
								<h2>Build Career With Us</h2>
							</div>
							<div class="col-md-10 col-md-offset-1">
								<div class="wow fadeInUp" data-wow-offset="0"
									data-wow-delay="0.6s">
									<p>Online Examination</p>
								</div>
							</div>
							<div class="wow fadeInUp" data-wow-offset="0"
								data-wow-delay="1.6s">
								<form class="form-inline">
									<div class="form-group">
										<button type="livedemo">
											<a href="regForm">Sign Up</a>
										</button>
									</div>
									<div class="form-group">
										<button type="livedemo">
											<a href="loginPage">Login</a>
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="item">
						<img src="img/slide.jpg" class="img-responsive" alt="">
						<div class="carousel-caption">
							<div class="wow fadeInUp" data-wow-offset="0"
								data-wow-delay="0.3s">
								<h2>Learn And Explore</h2>
							</div>
							<div class="col-md-10 col-md-offset-1">
								<div class="wow fadeInUp" data-wow-offset="0"
									data-wow-delay="0.6s">
									<p>Online Examination</p>
								</div>
							</div>
							<div class="wow fadeInUp" data-wow-offset="0"
								data-wow-delay="0.9s">
								<form class="form-inline">
									<div class="form-group">
										<button type="livedemo">
											<a href="regForm">Sign Up</a>
										</button>
									</div>
									<div class="form-group">
										<button type="livedemo">
											<a href="loginPage">Login</a>
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

				<a class="left carousel-control hidden-xs" href="#carousel-slider"
					data-slide="prev"> <i class="fa fa-angle-left"></i>
				</a> <a class=" right carousel-control hidden-xs"
					href="#carousel-slider" data-slide="next"> <i
					class="fa fa-angle-right"></i>
				</a>
			</div>
			<!--/#carousel-slider-->
		</div>
		<!--/#about-slider-->
	</div>
	<!--/#slider-->
	<hr>
	<%@include file="\WEB-INF\jsp\footer.jsp"%>

	<script type="text/javascript">
		document.getElementById("btn_signUp").onclick = function() {
			location.href = "/signup.html";
		};
	</script>
</body>

</html>
