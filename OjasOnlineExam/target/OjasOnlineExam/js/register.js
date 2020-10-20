
function register() {
	
	var fname = document.getElementById('firstName').value;
	var fnameRegExp = /^[a-z ,.'-]+$/i;
	var email = document.getElementById('email').value;
	var emailRegExp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var aadhar = document.getElementById('aadhar').value;
	var aadharRegExp = /^\d{4}\s\d{4}\s\d{4}$/;
	var gender = document.getElementById('gender').checked;
	var mobile = document.getElementById('mobile').value;
	var mobileregex = /^(\+\d{1,3}[- ]?)?\d{10}$/;
	var dob = document.getElementById('dateOfBirth').value;
	var dobregex = /^\d{2}([./-])\d{2}\1\d{4}$/;
	var qualification = document.getElementById('qualification').value;
	var experience = document.getElementById('experience').value;
	var technology = document.getElementById('technology').value;
	var address = document.getElementById('address').value;

	var errorMessage = "";
	var checkFormValidate = false;

	if (fname == "") {
		errorMessage = "firstName is required <br/>";
		checkFormValidate = true;
	} else {
		if (!fnameRegExp.test(fname)) {
			errorMessage += "Invalid  name <br/>";
			checkFormValidate = true;
		}
	}

	if (email == "") {
		errorMessage = "Email is required <br/>";
		checkFormValidate = true;
	} else {
		if (email.length < 6 || email.length > 30) {
			errorMessage += "Invalid Email <br/>";
			checkFormValidate = true;
		} else if (!emailRegExp.test(email)) {
			errorMessage += "Invalid  email <br/>";
			checkFormValidate = true;
		}
	}
	if (aadhar == "") {
		errorMessage = errorMessage + "aadhar is required";
		checkFormValidate = true;

	} else if (!aadharRegExp.test(aadhar)) {
			errorMessage += "Invalid  aadhar number <br/>";
			checkFormValidate = true;
	}

	if (gender == "") {
		errorMessage = "gender is required <br/>";
		checkFormValidate = true;
	}

	if (mobile == "") {
		errorMessage = "mobileNumber is required <br/>";
		checkFormValidate = true;
	} else {
		if (!mobileregex.test(mobile)) {
			errorMessage += "Invalid  mobileNumber <br/>";
			checkFormValidate = true;
		}
	}
	if (dob == "") {
		errorMessage = "date of birth is required <br/>";
		checkFormValidate = true;
	} else {
		if (!dobregex.test(dob)) {
			errorMessage += "Invalid  dateofbirth <br/>";
			checkFormValidate = true;
		}
	}
	if (address == "") {
		errorMessage = "address is required <br/>";
		checkFormValidate = true;
	}
	if (qualification == "") {
		errorMessage = "qualification is required <br/>";
		checkFormValidate = true;
	}
	if (experience == "") {
		errorMessage = "experience is required <br/>";
		checkFormValidate = true;
	}
	if (technology == "") {
		errorMessage = "technology is required <br/>";
		checkFormValidate = true;
	}

	if (checkFormValidate) {
		document.getElementById('loginErrorDiv').innerHTML = errorMessage;
		document.getElementById('loginErrorDiv').style.display = '';
		document.getElementById('ActionMsgDiv').style.display = 'none';
		return false;

	} else {
		document.loginForm.action = "login_testing.action";
		document.loginForm.submit();
		return true;
	}
 }


// added by naveenv
function initFocus() {
	document.getElementById('fname').focus();// added by naveenv
}

history.pushState({
	page : 1
}, "title 1", "#nbb");
window.onhashchange = function(event) {
	window.location.hash = "nbb";
}
