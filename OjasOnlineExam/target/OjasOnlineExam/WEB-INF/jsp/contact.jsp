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

	<section id="contact-page">
		<div class="container">
			<h2 class="clr2">Contact Us</h2>
			<div class="col-sm-6">
				<h4 class="clr1">Hyderabad, India</h4>
				<h5>Ojas Innovative Technologies Pvt. Ltd.</h5>
				<p>
					9th Floor, Block C,<br> MJR Magnifique, Raidurgam, <br>Hyderabad
					500 008<br> <i class="fa fa-phone"></i> +91-40-41430000<br>
					<i class="fa fa-envelope"></i> <a href="mailto:sales@ojas-it.com">Sales@Ojas-it.com</a>
				</p>
				<br>
				<div class="map">
					<!--<div id="google-map" data-latitude="40.713732" data-longitude="-74.0092704"></div>-->
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15227.119151719351!2d78.38188910000002!3d17.42235260000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xf5e18f0488344307!2sOjas+Innovative+Technologies+Pvt+Ltd!5e0!3m2!1sen!2sin!4v1524097532258"
						width="100%" height="300" frameborder="0" style="border: 0"
						allowfullscreen></iframe>
				</div>
			</div>
			<div class="col-md-4">
				<div id="sendmessage">Your message has been sent. Thank you!</div>
				<div id="errormessage"></div>
				<form action="" method="post" role="form" class="contactForm">
					<div class="form-group">
						<h3>Drop Your Message</h3>
						<br> <input type="text" name="name" class="form-control"
							id="name" placeholder="Your Name" data-rule="minlen:4"
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
						<input type="text" class="form-control" name="subject"
							id="subject" placeholder="Subject" data-rule="minlen:4"
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
						<button type="submit" name="submit" class="btn btn-primary btn-lg"
							required="required">
							<a href="index.jsp">Submit</a>
						</button>
					</div>
				</form>
			</div>
		</div>
		/.row /.container
	</section>

	<%@include file="footer.jsp"%>


	<script>
		(function($) {
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
		})(jQuery);
	</script>
	<script src="contactform/contactform.js"></script>

</body>

</html>
