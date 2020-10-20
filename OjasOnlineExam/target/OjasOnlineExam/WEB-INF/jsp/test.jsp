<!DOCTYPE html5>
<html lang="en">

<head>
<title>Ojas Online Exam</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.css">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/style.css" rel="stylesheet" />
</head>

<body oncontextmenu="return false" onselectstart="return false"
	ondragstart="return false">
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
						<a href="index.html"><h1></h1></a>
					</div>
				</div>
				<div class="navbar-collapse collapse">
					<h1 align="center">Online Java Test</h1>
				</div>
			</div>
			<!--/.container-->
		</nav>
		<!--/nav-->
	</header>
	<div class="container" style="color: black">
		<div>
			<h2 align="right" id="header2">
				Time left :<span id="time">30:00</span>
			</h2>
			<br />
			<h4>1. What is the stored in the object obj in following lines
				of code?</h4>
			<div class="container">
				<form>
					<label class="radio"> <input type="radio" name="optradio">
						Memory address of allocated memory of object
					</label> <label class="radio"> <input type="radio" name="optradio">
						NULL
					</label> <label class="radio"> <input type="radio" name="optradio">Any
						arbitrary pointer
					</label> <label class="radio"> <input type="radio" name="optradio">Garbage
					</label>
				</form>
			</div>

			<h4>2. Which of these keywords is used to make a class?</h4>
			<div class="container">
				<form>
					<label class="radio"> <input type="radio" name="optradio">class
					</label> <label class="radio"> <input type="radio" name="optradio">struct
					</label> <label class="radio"> <input type="radio" name="optradio">int
					</label> <label class="radio"> <input type="radio" name="optradio">
						none of the mentioned
					</label>
				</form>
			</div>

			<h4>3.Which of the following is a valid declaration of an object
				of class Box?</h4>
			<div class="container">
				<form>
					<label class="radio"> <input type="radio" name="optradio">Box
						obj = new Box();
					</label> <label class="radio"> <input type="radio" name="optradio">Box
						obj = new Box;
					</label> <label class="radio"> <input type="radio" name="optradio">
						obj = new Box();
					</label> <label class="radio"> <input type="radio" name="optradio">
						obj = new Box();
					</label>
				</form>
			</div>

			<h4>4. Which of these statement is incorrect?</h4>
			<div class="container">
				<form>
					<label class="radio"> <input type="radio" name="optradio">Every
						class must contain a main() method
					</label> <label class="radio"> <input type="radio" name="optradio">Applets
						do not require a main() method at all
					</label> <label class="radio"> <input type="radio" name="optradio">There
						can be only one main() method in a program
					</label> <label class="radio"> <input type="radio" name="optradio">main()
						method must be made public
					</label>
				</form>
			</div>

			<h4>5. Which of the following statements is correct?</h4>
			<div class="container">
				<form>
					<label class="radio"> <input type="radio" name="optradio">Public
						method is accessible to all other classes in the hierarchy
					</label> <label class="radio"> <input type="radio" name="optradio">Public
						method is accessible only to subclasses of its parent class
					</label> <label class="radio"> <input type="radio" name="optradio">Public
						method can only be called by object of its class
					</label> <label class="radio"> <input type="radio" name="optradio">Public
						method can be accessed by calling object of the public class
					</label>
				</form>
			</div>

			<div class="col text-right ,btn-toolbar">
				<!-- 	<button class="btn btn-danger" type="reset">Reset</button> -->
				<button class="btn btn-success" type="submit"
					onclick="alert('You have completed your exam successfully.')">
					<a href="index.jsp">Submit</a>
				</button>

			</div>

			<nav aria-label="...">
				<ul class="pagination">
					<li class="page-item disabled"><span class="page-link">Previous</span>
					</li>
					<li class="page-item active"><a href="test.html"> 1</a></li>
					<li class="page-item"><a class="page-link" href="test1.html">2</a></li>
					<!-- <li class="page-item"><a class="page-link" href="#">3</a></li> -->
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>

			</nav>
			<br>

		</div>
	</div>
	<script>
		function startTimer(duration, display) {
			var timer = duration, minutes, seconds;
			setInterval(function() {
				minutes = parseInt(timer / 60, 10)
				seconds = parseInt(timer % 60, 10);

				minutes = minutes < 10 ? "0" + minutes : minutes;
				seconds = seconds < 10 ? "0" + seconds : seconds;

				display.textContent = minutes + ":" + seconds;

				if (--timer < 0) {
					timer = duration;
				}
			}, 1000);
		}

		window.onload = function() {
			var thirtyMinutes = 60 * 30, display = document
					.querySelector('#time');
			startTimer(thirtyMinutes, display);
		};
	</script>
	<div class="sub-footer">
		<div class="container">
			<div class="col-md-5 col-md-offset-4">
				<div class="copyright">
					&copy; 2011-2018 Ojas Innovative Technologies. All Rights Reserved.
					<div class="credits">
						<a href="https://bootstrapmade.com/"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
