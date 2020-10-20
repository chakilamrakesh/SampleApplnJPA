<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ojas Online Exam</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.css">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
<!-- Bootstrap -->

<link href="css1/responsive-slider.css" rel="stylesheet">
<link href="css/reportcss.css" rel="stylesheet">

<script type="text/javascript" src="assets/js/bootstrap.js"></script>
</head>


<body>
	<%@include file="adminHeader.jsp"%>


	<div class="container" style="height: 100px"></div>
	<div class="container" style="color: black">
		<div class="row">
			<div class="col-xs-6">
				<!-- tabs -->
				<div class="tabbable tabs-center">

					<div class="tab-content">
						<div class="tab-pane active" id="testReport">
							<div class="">
								<h3>Test Analysis</h3>
								<div id="report-right1">
									<table class="table table-bordered">
										<tr>
											<th rowspan="2" style="width: 40px; height: 40px;">S.No.</th>
											<th id="th3" style="text-align: center;" rowspan="2">
												Test</th>
											<th rowspan="2" style="width: 20%">Total Candidates</th>
											<th rowspan="2" style="width: 20%">Avg. Score</th>
											<th rowspan="2" style="width: 20%">Topper's Marks</th>
											<th colspan="2">Total Candidates</th>
										</tr>
										<tr>
											<th style="width: 15%">Above Avg.</th>
											<th style="width: 15%">Below Avg.</th>
										</tr>
										<tr>
											<td>1</td>
											<td>Java</td>
											<td>50</td>
											<td>56</td>
											<td>99</td>


											<td>30
											<td>20</td>
											</td>
										</tr>

										<tr>
											<td>2</td>
											<td>UI</td>
											<td>70</td>
											<td>76</td>
											<td>89</td>


											<td>40
											<td>30</td>
											</td>
										</tr>
										<tr>
											<td>3</td>
											<td>IDM</td>
											<td>70</td>
											<td>56</td>
											<td>89</td>


											<td>40
											<td>30</td>
											</td>
										</tr>

									</table>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="candidateReport">
							<div class="">
								<h3>Candidate Test Report</h3>
							</div>
						</div>
					</div>
				</div>
				<!-- /tabs -->
			</div>
		</div>
	</div>

	<div class="container" style="height: 100px"></div>

	<%@include file="footer.jsp"%>



</body>

</html>
