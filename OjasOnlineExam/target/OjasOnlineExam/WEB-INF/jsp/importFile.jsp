
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


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

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/upload.js"></script>
</head>

<body>
	<%@include file="adminHeader.jsp"%>

	<div class="container">
		<div class="panel panel-default">

			<div class="panel-body">

				<!-- Standar Form -->
				<h4>Select files from your computer</h4>
				<spring:url value="/doUpload" var="doUploadURL"></spring:url>
				<form:form action="${doUploadURL}" method="POST"
					modelAttribute="fileBean" enctype="multipart/form-data"
					id="js-upload-form">
					<div class="form-inline">

						<div class="form-group">
							<label>Upload Your File </label> <input type="file"
								name="fileBean" class="form-control" />
						</div>



						<button type="submit" class="btn btn-sm btn-primary"
							id="js-upload-submit">Upload files</button>
					</div>
				</form:form>

				<!-- Drop Zone -->
				<h4>Or drag and drop files below</h4>
				<div class="upload-drop-zone" id="drop-zone">Just drag and
					drop files here</div>

			</div>
		</div>
	</div>



	<%@include file="footer.jsp"%>

</body>

</html>
