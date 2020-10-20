<!DOCTYPE html5>
<html lang="en">

<head>
<title>Ojas Online Exam</title>
<!-- <link rel="stylesheet" href="style/Test.css"> -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/style.css" rel="stylesheet" />
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.css">
<link href="css/animate.min.css" rel="stylesheet">
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
						<a href="index.jsp"><h1></h1></a>
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
		<h2 align="right" id="header2">
			Time left :<span id="time">30:00</span>
		</h2>
		<div>
			<br />
			<h4>6. Why java does not support pointers?</h4>
			<div class="container">
				<form>
					<textarea rows="4" cols="60" name="textarea"></textarea>
					<br />
					<!-- <input type="submit" value="save" name="submit"> -->
				</form>
			</div>

			<h4>7. how to create custom immutable class in java?</h4>
			<div class="container">
				<form>
					<textarea rows="4" cols="60" name="textarea"></textarea>
					<br />
					<!-- <input type="submit" value="save" name="submit"> -->
				</form>
			</div>

			<h4>8. Why java does not support multiple inheritance through
				classes?</h4>
			<div class="container">
				<form>
					<textarea rows="4" cols="60" name="textarea"></textarea>
					<br />
					<!-- <input type="submit" value="save" name="submit"> -->
				</form>
			</div>

			<h4>9. How to create customized Exception in java?</h4>
			<div class="container">
				<form>
					<textarea rows="4" cols="60" name="textarea"></textarea>
					<br />
					<!-- <input type="submit" value="save" name="submit"> -->
				</form>
			</div>

			<h4>10.What is synchronization and why is it important? ?</h4>
			<div class="container">
				<form>
					<textarea rows="4" cols="60" name="textarea"></textarea>
					<br />
					<!-- <input type="submit" value="save" name="submit"> -->
				</form>
			</div>

			<div class="col text-right ,btn-toolbar">
				<!-- 	<button class="btn btn-danger" type="reset">Reset</button> -->
				<button class="btn btn-success" type="submit"
					onclick="alert('You have completed your exam successfully.')">
					<a href="index.html">Submit</a>
				</button>

			</div>

			<nav aria-label="...">
				<ul class="pagination">
					<li class="page-item disabled"><span class="page-link">Previous</span>
					</li>
					<li class="page-item "><a href="test.html"> 1</a></li>
					<li class="page-item active"><a class="page-link"
						href="test1.html">2</a></li>
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