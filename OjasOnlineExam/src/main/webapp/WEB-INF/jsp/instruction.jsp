<!DOCTYPE html>
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

</head>

<body>

	<%@include file="header.jsp"%>

	<div class="container">
		<h2>Welcome to online exam !</h2>
		<p>Please read the below instructions carefully</p>

		<div>
			<h3>Instructions</h3>

			<div>
				<h4>
					<b>Before beginning the exam</b>
				</h4>
				<p>
				<ul style="color: black" style="width: 80%">
					<li>1.Close all programs, including email.</li>

					<li>2.Enter the Online exam using Google Chrome.Do not use any
						other internet browser.</li>
					<li>3.Maximize your browser window before strating the
						test.Minimizing the browser window during the exam can prevent the
						submission of your exam.</li>
					<li>4.Click on "Start Test" button To start the online Exam
						which is at the bottom of the screen</li>
				</ul>

				<p>
				<ul style="color: black" style="width: 80%">
					<h4>
						<b>During the exam</b>
					</h4>
					<li>1.Do not minimize the browser during the test</li>
					<li>2. Do Not Use the "Back" Button on Your Browser During the
						Test once you have begun taking the test. Instead, use the scroll
						bar to move back to check earlier questions. Don't close the
						window of the test for any reason.</li>

					<li>3.The exam must be completed in one sitting.you can only
						open it once</li>
					<li>4.you will have 1 hour to complete your exam</li>
					<li>5.Answer all questions in the exam</li>

					<li>6.Save your test using the "Save" button periodically
						during the exam.</li>
					<li>7.Click the "Submit" button to submit your exam.Do not
						press "Enter" on the keyboard to submit the exam.</li>
				</ul>

			</div>

			<input type="checkbox" name="terms" id="terms"
				onchange="activateButton(this)"><label style="color: black">&nbsp;&nbsp;I
				Agree Terms & Coditions</label> <br>
		</div>
		<button type="submit"
			onclick="alert('Attention ! the page is redirecting to the test!')">
			<a href="getQuestionsForUserExam" class="button">Start Test</a>
		</button>
	</div>

	<hr>

	<%@include file="footer.jsp"%>

	<script type="text/javascript">
		document.getElementById("btn_signUp").onclick = function() {
			location.href = "/signup.jsp";
		};
	</script>
</body>

</html>
