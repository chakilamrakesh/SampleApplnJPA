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
	<%@ include file="header.jsp"%>

	<div class="container" style="color: black">
		<div>
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title" align="center">Upload Questions</h1>
					<hr />
				</div>
			</div>
			<div>
				<div>
					<form class="form-horizontal" role="form" action="">

						<div class="form-group">
							<label for="ques" class="cols-sm-2 control-label">Question</label>
							<div class="cols-sm-10">
								<div class="input-group">

									<textarea rows="4" cols="50" style="width: 137%">

                             </textarea>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="option 1" class="cols-sm-2 control-label">Option
								1</label>
							<div class="cols-sm-10">
								<div class="input-group">

									<input type="text" class="form-control" name="option1"
										id="option1" style="width: 263%" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="option 2" class="cols-sm-2 control-label">Option
								2</label>
							<div class="cols-sm-10">
								<div class="input-group">

									<input type="text" class="form-control" name="option2"
										id="option2" style="width: 263%" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="option 3" class="cols-sm-2 control-label">Option
								3</label>
							<div class="cols-sm-10">
								<div class="input-group">

									<input type="text" class="form-control" name="option3"
										id="option3" style="width: 263%">
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="option 4" class="cols-sm-2 control-label">Option
								4</label>
							<div class="cols-sm-10">
								<div class="input-group">

									<input type="text" class="form-control" name="option4"
										id="option4" style="width: 263%" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="correct" class="cols-sm-2 control-label">Correct
								Answer</label>
							<div class="cols-sm-10">
								<div class="input-group">

									<input type="text" class="form-control" name="correct"
										id="correct" style="width: 263%" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="set" class="cols-sm-2 control-label">Set No.</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<select name="drp" id="drp" width="400px">
										<option value="set1">Set No.1</option>
										<option value="set2">Set No.2</option>
										<option value="set3">Set No.3</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group " align="center">
							<button type="button"
								class="btn btn-primary btn-lg btn-block login-button"
								style="width: 30%">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>



	<%@include file="footer.jsp"%>

</body>

</html>
