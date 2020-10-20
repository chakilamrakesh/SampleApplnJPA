<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ojas Online Exam</title>

<!-- Bootstrap -->
<link href="css1/bootstrap.min.css" rel="stylesheet">
<link href="css1/responsive-slider.css" rel="stylesheet">
<link rel="stylesheet" href="css1/animate.css">
<link rel="stylesheet" href="css1/font-awesome.min.css">
<link href="css1/style.css" rel="stylesheet">

</head>

<body>


	<%@ include file="header.jsp"%>

	<div class="container">
		<div class="col-lg-6">
			<div id="sendmessage">Your message has been sent. Thank you!</div>
			<div id="errormessage"></div>
			<form action="" method="post" role="form" class="contactForm">
				<div class="form-group">
					<input type="text" name="name" class="form-control" id="name"
						placeholder="Your Name" data-rule="minlen:4"
						data-msg="Please enter at least 4 chars" />
					<div class="validation"></div>
				</div>
				<div class="form-group">
					<input type="email" class="form-control" name="email" id="email"
						placeholder="Your Email" data-rule="email"
						data-msg="Please enter a valid email" />
					<div class="validation"></div>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="subject" id="subject"
						placeholder="Subject" data-rule="minlen:4"
						data-msg="Please enter at least 8 chars of subject" />
					<div class="validation"></div>
				</div>
				<div class="form-group">
					<textarea class="form-control" name="message" rows="5"
						data-rule="required" data-msg="Please write something for us"
						placeholder="Message"></textarea>
					<div class="validation"></div>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-default">Send Message</button>
				</div>
				<div class="col-md-10 text-right">
					<button class="btn btn-light ">
						<a href="loginPage" />LOGIN HERE</a>
					</button>
				</div>
			</form>

		</div>
		<div class="col-lg-2">

			<img alt="" src="img1/cmmi.png" height="200px" width="400px">

		</div>
	</div>


	<address>
		<strong> <!-- Written by:<a href="https://bootstrapmade.com" target="_blank">Gampang Prasetyo</a><br>
			Visit us at:<br>
			<a href="https://bootstrapmade.com" target="_blank">http://bootstrapmade.com</a><br>
			Box 564, Disneyland<br>
			USA<br> --> Ojas Innovative Technologies Pvt Ltd (ISO 9001:2015, ISO
			27001:2013) <br>9th Floor, Block C, MJR Magnifique, Raidurgam<br>
			Hyderabad-500032


		</strong>
	</address>

	<hr>
	<%@include file="footer.jsp"%>

	<script>
		wow = new WOW({}).init();
	</script>
	<script>
		jQuery(document).ready(
				function($) {
					//Google Map
					var get_latitude = $('#google-map').data('latitude');
					var get_longitude = $('#google-map').data('longitude');

					function initialize_google_map() {
						var myLatlng = new google.maps.LatLng(get_latitude,
								get_longitude);
						var mapOptions = {
							zoom : 14,
							scrollwheel : false,
							center : myLatlng
						};
						var map = new google.maps.Map(document
								.getElementById('google-map'), mapOptions);
						var marker = new google.maps.Marker({
							position : myLatlng,
							map : map
						});
					}
					google.maps.event.addDomListener(window, 'load',
							initialize_google_map);
				});
	</script>
	<script src="contactform/contactform.js"></script>

</body>

</html>
