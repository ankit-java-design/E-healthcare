<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
.paddingTB60 {
	padding: 60px 0px 60px 0px;
}

.gray-bg {
	background: #F1F1F1 !important;
}

.about-title {
	
}

.about-title h1 {
	color: #535353;
	font-size: 45px;
	font-weight: 600;
}

.about-title span {
	color: #AF0808;
	font-size: 45px;
	font-weight: 700;
}

.about-title h3 {
	color: #535353;
	font-size: 23px;
	margin-bottom: 24px;
}

.about-title p {
	color: #7a7a7a;
	line-height: 1.8;
	margin: 0 0 15px;
}

.about-paddingB {
	padding-bottom: 12px;
}

.about-img {
	padding-left: 57px;
}

/* Social Icons */
.about-icons {
	margin: 48px 0px 48px 0px;
}

.about-icons i {
	margin-right: 10px;
	padding: 0px;
	font-size: 35px;
	color: #323232;
	box-shadow: 0 0 3px rgba(0, 0, 0, .2);
}

.about-icons li {
	margin: 0px;
	padding: 0;
	display: inline-block;
}

#social-fb:hover {
	color: #3B5998;
	transition: all .001s;
}

#social-tw:hover {
	color: #4099FF;
	transition: all .001s;
}

#social-gp:hover {
	color: #d34836;
	transition: all .001s;
}

#social-em:hover {
	color: #f39c12;
	transition: all .001s;
}
</style>
<meta charset="ISO-8859-1">

<title>About Us</title>

</head>
<body>

	<%@include file="Header.jsp"%>

	<div class="about-section paddingTB60 gray-bg">
		<div class="container">
			<div class="row">
				<div class="col-md-7 col-sm-6">
					<div class="about-title clearfix">
						<h1>
							About <span>E-Healthcare</span>
						</h1>
						<h3>Prescribe Medication and administer treatments based on the diagnosis</h3>
						<p class="about-paddingB">Accessing healthcare services is a fundamental aspect of maintaining well-being,
						 yet the process of finding the right doctor and scheduling appointments can often be challenging and time-consuming.
						  In today's fast-paced world, individuals face numerous obstacles in navigating the healthcare system
						  , including long wait times, limited availability of appointments, and difficulties in
						   finding doctors who meet their specific needs.The project on "E-Healthcare" seeks to address these challenges
						    by developing a comprehensive solution to streamline the process of finding doctors and booking appointments.
						     By leveraging digital tools and innovative technologies, this project aims to create a user-friendly 
						    platform that empowers individuals to access healthcare services more efficiently and effectively
						<div class="about-icons">
						</div>
					</div>
				</div>
				<div class="col-md-5 col-sm-6">
					<div class="about-img">
						<img
							src="<%=DFViewCtl.APP_CONTEXT%>/image/ThAOKju-doctor-wallpaper.jpg"
							style="width: 600px; height: 500px;" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>



	<%@include file="Footer.jsp"%>

</body>
</html>