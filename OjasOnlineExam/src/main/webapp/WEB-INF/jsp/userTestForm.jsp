<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
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

<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<style>
table, th, td {
	border: 2px solid powderblue;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: left;
}

p {
	border: 1px solid powderblue;
}
</style>

<script type="text/javascript" >   
function disableBackButton()
{
window.history.forward()
}  
disableBackButton();  
window.onload=disableBackButton();  
window.onpageshow=function(evt) { if(evt.persisted) disableBackButton() }  ;
window.onunload=function() { void(0) } ;

/* document.addEventListener('contextmenu', event => event.preventDefault()); */


</script>

</head>



<!-- <script>

window.onbeforeunload = function() {
	  return "Data will be lost if you leave the page, are you sure?";
	};

</script> -->

<script>
    $('.nav-collapse').click('li', function () {
        $('.nav-collapse').collapse('hide');
    });
    var myVar = setInterval(function () {
        myTimer()
    }, 1000);
    var d = 600;
    var min, sec;
    function myTimer() {
        d--;
        min = parseInt(d / 60);
        sec = parseInt((d / 60 - min) * 59);
        document.getElementById("timeleft").innerHTML = min + " miunte " + sec + " second left";
    }
</script>
 
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
						<a href="index.jsp"></a>
					</div>
				</div>
				<div class="navbar-collapse collapse">
					<div class="menu">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation"><a class="active"><font
									color="Blue">OJAS ONLINE EXAM</font></a></li>
							<li role="presentation"></li>
						</ul>

					</div>
				</div>
			</div>
	</header>
	
	<body onload="noBack();">
	<div class="container" style="color: black">
		<div>
			<h2 align="right" id="header2">
				Time left :<span id="time">30:00</span>
			</h2>
	<%-- <form:form name="resultForm" action="result"
			class="form-horizontal" role="form" method="post"
			modelAttribute="resultForm">
			<%
				int i = 0;
			%>
		
			<c:forEach var="questionlist" items="${questionslist}">
				<h4>
					<%
					out.print(++i  );
					%> . ${questionlist.question}	
				</h4>
								<input type="hidden" value="${quiz_ques.id}" name="question${questionlist.question}_id">
                    <h5>${quiz_ques.text}</h5>
						<form>
						<label class="radio" > <input type="radio" id="${questionlist.id}" name="Useroption" value="option1">
							${questionlist.option1}
						</label> 
						<label class="radio"> <input type="radio" id="${questionlist.id}" name="Useroption" value="option2">
							${questionlist.option2}
						</label> 
						<label class="radio"> <input type="radio" id="${questionlist.id}" name="Useroption" value="option3">
							${questionlist.option3}
						</label> 
						<label class="radio"> <input type="radio" id="${questionlist.id}" name="Useroption" value="option4">
						    ${questionlist.option4}
						</label>
												
					</form>
					
					
			</c:forEach>
			
			<div class="col text-right ,btn-toolbar">
				<!-- 	<button class="btn btn-danger" type="reset">Reset</button> -->
				<button class="btn btn-success" type="submit"
					onclick="alert('You have completed your exam successfully.')">Submit
				</button>
			</div>
			
			</form:form> --%>






<form class="form-horizontal" method="post" action="result">
        <fieldset>
            <legend>
                
                <span id="timeleft" class="text-right"></span>
            </legend>
            <c:forEach items="${questionslist}"  var="quiz_ques" varStatus="loopCounter">
            <div class="quiz-ques form-group">
                <label class="col-lg-2 control-label">${loopCounter.count}</label>
                <div class="col-lg-10 text-left">
                    <input type="hidden" value="${quiz_ques.id}" name="question${loopCounter.count}_id">
                    <h5>${quiz_ques.question}</h5>
                    <label>
                        <input type="radio" name="question${loopCounter.count}_option"  value="option1">
                            ${quiz_ques.option1}                    </label><br>
                    <label>
                        <input type="radio" name="question${loopCounter.count}_option"  value="option2">
                            ${quiz_ques.option2}                    </label><br>
                    <label>
                        <input type="radio" name="question${loopCounter.count}_option"  value="option3">
                            ${quiz_ques.option3}                    </label><br>
                    <label>
                        <input type="radio" name="question${loopCounter.count}_option"  value="option4">
                            ${quiz_ques.option4}                    </label>
                </div>
            </div>
            </c:forEach>

            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-5">
                    <button type="reset" class="btn btn-default">Reset</button>
                    <button type="submit" class="btn btn-primary">Submit your Quiz</button>
                </div>
            </div>
        </fieldset>
    </form>
			
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
	<hr>
</body>

</html>