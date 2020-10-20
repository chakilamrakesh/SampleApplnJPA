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

	<%@include file="adminHeader.jsp"%>



	<!--/header-->
	<div class="container" style="color: black" style="height: 1000px">
		<div class="panel panel-primary">
			<div class="panel-heading">Enter Subjects</div>
			<div class="panel-body">
				<form action="">
					Add Subject:<br> <input type="text" class="form-control"
						id="usr" value="subject"> <br>
					<button type="submit" class="btn btn-primary " align="center">submit</button>
			</div>
		</div>
		</form>
	</div>

	<%@include file="footer.jsp"%>
	<script type="text/javascript">
		document.getElementById("btn_signUp").onclick = function() {
			location.href = "/signup.jsp";
		};
	</script>
</body>

</html>
l>
