<%@page import="ehealthcare.Controller.RegistrationCtl"%>
<%@page import="ehealthcare.Controller.LoginCtl"%>
<%@page import="ehealthcare.Bean.UserBean"%>

<%@page import="ehealthcare.Controller.DFViewCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HeaderView</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.2.0/css/all.min.css"
	integrity="sha512-6c4nX2tn5KbzeBJo9Ywpa0Gkt+mzCzJBrE1RB6fmpcsoN+b/w/euwIMuQKNyUoU/nToKN3a8SgNOtPrbW12fug=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
	
	
</head>
<body>

	<%
		UserBean userBean = (UserBean) session.getAttribute("user");
	%>
	<%
		boolean userLoggedIn = userBean != null;

		String welcomeMsg = "Hello, ";

		if (userLoggedIn) {
			//String lastname =  userBean.getLastName();
			welcomeMsg += userBean.getName();
		} else {
			welcomeMsg += "Guest";
		}
	%>

	<!-- As a heading -->
	<nav class="navbar bg-light">
	
		<span class="navbar-brand mb-0 h1" style="color: teal;"><i class='fas fa-hand-holding-medical' style='font-size:45px;  margin-left: 5px; margin-right:5px;  color:red'></i>E-Healthcare</a>
		</span>
	</nav>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
			
				<li class="nav-item active"><a class="nav-link"
					href="<%=DFViewCtl.WELCOME_CTL%>"><i class='fas fa-house-user' style='font-size:22px;color:teal;margin-right: 5px;'></i>Home</a></li>
				

				<%
					if (userBean != null) {
				%>

				<%
					if (userBean.getRoleid() == 1) {
				%>

				<li class="nav-item active"><a class="nav-link"
					href="<%=DFViewCtl.ABOUT_CTL%>"><i class='fa fa-address-card' style='font-size:22px;color:teal;margin-right: 5px;'></i>About</a></li>



<li class="nav-item active"><a class="nav-link"
					href="<%=DFViewCtl.USER_LIST_CTL%>"><i class='fas fa-user-alt' style='font-size:22px;color:teal;margin-right: 5px;'></i>UserList</a></li>



				<%-- <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDarkDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"><i class='fas fa-user-alt' style='font-size:22px;color:teal;margin-right: 5px;'></i>User</a>
							<ul class="dropdown-menu dropdown-menu-dark"
								aria-labelledby="navbarDarkDropdownMenuLink">
								<li><a class="dropdown-item" href="<%=DFViewCtl.USER_CTL%>">Add
										User</a></li>
								<li><a class="dropdown-item"
									href="<%=DFViewCtl.USER_LIST_CTL%>">UserList</a></li>
							</ul></li>
					</ul>
				</div> --%>


				<div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDarkDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"><i class='fas fa-clinic-medical' style='font-size:22px;color:teal;margin-right: 5px;'></i>Doctor</a>
							<ul class="dropdown-menu dropdown-menu-dark"
								aria-labelledby="navbarDarkDropdownMenuLink">
								<li><a class="dropdown-item"
									href="<%=DFViewCtl.DOCTOR_CTL%>">Add Doctor</a></li>
								<li><a class="dropdown-item"
									href="<%=DFViewCtl.DOCTOR_LIST_CTL%>">View Doctors</a></li>
							</ul></li>
					</ul>
				</div>




				<div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDarkDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"><i class='fa fa-wheelchair' style='font-size:22px;color:teal;margin-right: 5px;'></i>Appointment</a>
							<ul class="dropdown-menu dropdown-menu-dark"
								aria-labelledby="navbarDarkDropdownMenuLink">
								<%-- <li><a class="dropdown-item"
									href="<%=DFViewCtl.APPOINTMENT_CTL%>">ADD Appointments</a></li> --%>
								<li><a class="dropdown-item"
									href="<%=DFViewCtl.APPOINTMENT_LIST_CTL%>">Show
										Appointments</a></li>
							</ul></li>
					</ul>
				</div>

				<!-- <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDarkDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">consultation Fees</a>
							<ul class="dropdown-menu dropdown-menu-dark"
								aria-labelledby="navbarDarkDropdownMenuLink">
								<li><a class="dropdown-item" href="">Add consultation Fees</a></li>
								<li><a class="dropdown-item" href="">consultation Fees List </a></li>
							</ul></li>
					</ul>
				</div> -->



				<%-- 				<li class="nav-item active"><a class="nav-link" href="<%=OCRView.ROLE_CTL%>">ADD Role</a></li>
 --%>
<li class="nav-item"><a class="nav-link"
					href="<%=DFViewCtl.PAYMENT_LIST_CTL%>"><i class='fas fa-bed' style='font-size:22px;color:teal;margin-right: 5px;'></i>Payment History</a></li>


				<%-- <li class="nav-item active"><a class="nav-link"
					href="<%=DFViewCtl.CONTACT_CTL%>"><i class='fas fa-phone-square-alt' style='font-size:25px;color:teal;margin-right: 5px;'></i>Contact Us</a></li>
 --%>

				<%
					} else if (userBean.getRoleid() == 2) {
				%>



				<li class="nav-item"><a class="nav-link"
					href="<%=DFViewCtl.ABOUT_CTL%>"><i class='fa fa-address-card' style='font-size:22px;color:teal;margin-right: 5px;'></i>About</a></li>

				<li class="nav-item active"><a class="nav-link" href="<%=DFViewCtl.DOCTOR_VIEW_CTL%>"><i class='fas fa-house-user' style='font-size:22px;color:teal;margin-right: 5px;'></i>Doctor List</a></li>


<%-- <li class="nav-item"><a class="nav-link"
					href="<%=DFViewCtl.APPOINTMENT_CTL%>"><i class='fas fa-bed' style='font-size:22px;color:teal;margin-right: 5px;'></i>Book Appointments</a></li> --%>

				<li class="nav-item"><a class="nav-link"
					href="<%=DFViewCtl.APPOINTMENT_LIST_CTL%>"><i class='fa fa-wheelchair' style='font-size:22px;color:teal;margin-right: 5px;'></i>Show Appointments</a></li>

<li class="nav-item"><a class="nav-link"
					href="<%=DFViewCtl.PAYMENT_LIST_CTL%>"><i class='fas fa-bed' style='font-size:22px;color:teal;margin-right: 5px;'></i>Payment History</a></li>


				<li class="nav-item"><a class="nav-link"
					href="<%=DFViewCtl.CONTACT_CTL%>"><i class='fas fa-phone-square-alt' style='font-size:25px;color:teal;margin-right: 5px;'></i>Contact</a></li>

				<%
					}
				%>
				<%
					}
				%>

			</ul>

		</div>


	<%
				if (userBean == null) {
			%>
		

			<ul class="nav justify-content-end">
			
<%-- 		<li class="nav-item active"><a class="nav-link" href="<%=DFViewCtl.DOCTOR_VIEW_CTL%>"><i class='fas fa-house-user' style='font-size:22px;color:teal;margin-right: 5px;'></i>Find Doctor</a></li>
 --%>		
			<ul class="nav justify-content-end" style="margin-right: 30px;">
				<div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDarkDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"><i class='fas fa-user-alt' style='font-size:22px;color:teal; margin-right: 5px;'></i>Guest</a>
							<ul class="dropdown-menu dropdown-menu-dark"
								aria-labelledby="navbarDarkDropdownMenuLink">
								<li><a class="dropdown-item"
									href="<%=DFViewCtl.LOGIN_CTL%>"><i class='fas fa-sign-in-alt' style='font-size:22px;color:teal; margin-right: 5px;'></i>SingIn</a></li>
								<li><a class="dropdown-item"
									href="<%=DFViewCtl.REGISTRAION_CTL%>"><i class='fa fa-registered' style='font-size:22px;color:teal; margin-right: 5px;'></i>Registered</a></li>
							</ul></li>
					</ul>
				</div>
			</ul>
			<%
				} else {
			%>
			<ul class="nav justify-content-end" style="margin-right: 30px;">
				<div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDarkDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"><i class='fas fa-user-alt' style='font-size:22px;color:teal;margin-right: 5px;'></i><%=welcomeMsg%></a>
							<ul class="dropdown-menu dropdown-menu-dark"
								aria-labelledby="navbarDarkDropdownMenuLink">
								<li><a class="dropdown-item"
									href="<%=DFViewCtl.LOGIN_CTL%>?operation=<%=LoginCtl.OP_LOGOUT%>"><i class='fas fa-sign-out-alt' style='font-size:22px;color:teal;margin-right: 5px;'></i>Logout</a></li>

							</ul></li>
					</ul>
				</div>
			</ul>


			<%
				}
			%>

		</ul>
	</nav>
</body>
</html>