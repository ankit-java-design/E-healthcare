<%@page import="ehealthcare.Controller.PaymentCt"%>
<%@page import="ehealthcare.Utility.DataUtility"%>
<%@page import="ehealthcare.Utility.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
	margin: 0;
	padding: 0
}

body {
	overflow-x: hidden;
	background: #000000
}

#bg-div {
	margin: 0;
	margin-top: 100px;
	margin-bottom: 100px
}

#border-btm {
	padding-bottom: 20px;
	margin-bottom: 0px;
	box-shadow: 0px 35px 2px -35px lightgray
}

#test {
	margin-top: 0px;
	margin-bottom: 40px;
	border: 1px solid #FFE082;
	border-radius: 0.25rem;
	width: 60px;
	height: 30px;
	background-color: #FFECB3
}

.active1 {
	color: #00C853 !important;
	font-weight: bold
}

.bar4 {
	width: 35px;
	height: 5px;
	background-color: #ffffff;
	margin: 6px 0
}

.list-group .tabs {
	color: #000000
}

#menu-toggle {
	height: 50px
}

#new-label {
	padding: 2px;
	font-size: 10px;
	font-weight: bold;
	background-color: red;
	color: #ffffff;
	border-radius: 5px;
	margin-left: 5px
}

#sidebar-wrapper {
	min-height: 100vh;
	margin-left: -15rem;
	-webkit-transition: margin .25s ease-out;
	-moz-transition: margin .25s ease-out;
	-o-transition: margin .25s ease-out;
	transition: margin .25s ease-out
}

#sidebar-wrapper .sidebar-heading {
	padding: 0.875rem 1.25rem;
	font-size: 1.2rem
}

#sidebar-wrapper .list-group {
	width: 15rem
}

#page-content-wrapper {
	min-width: 100vw;
	padding-left: 20px;
	padding-right: 20px
}

#wrapper.toggled #sidebar-wrapper {
	margin-left: 0
}

.list-group-item.active {
	z-index: 2;
	color: #fff;
	background-color: #fff !important;
	border-color: #fff !important
}

@media ( min-width : 768px) {
	#sidebar-wrapper {
		margin-left: 0
	}
	#page-content-wrapper {
		min-width: 0;
		width: 100%
	}
	#wrapper.toggled #sidebar-wrapper {
		margin-left: -15rem;
		display: none
	}
}

.card0 {
	margin-top: 10px;
	margin-bottom: 10px
}

.top-highlight {
	color: #00C853;
	font-weight: bold;
	font-size: 20px
}

.form-card input, .form-card textarea {
	padding: 10px 15px 5px 15px;
	border: none;
	border: 1px solid lightgrey;
	border-radius: 6px;
	margin-bottom: 25px;
	margin-top: 2px;
	width: 100%;
	box-sizing: border-box;
	font-family: arial;
	color: #2C3E50;
	font-size: 14px;
	letter-spacing: 1px
}

.form-card input:focus, .form-card textarea:focus {
	-moz-box-shadow: 0px 0px 0px 1.5px skyblue !important;
	-webkit-box-shadow: 0px 0px 0px 1.5px skyblue !important;
	box-shadow: 0px 0px 0px 1.5px skyblue !important;
	font-weight: bold;
	border: 1px solid skyblue;
	outline-width: 0
}

input.btn-success {
	height: 50px;
	color: #ffffff;
	opacity: 0.9
}

#below-btn a {
	font-weight: bold;
	color: #000000
}

.input-group {
	position: relative;
	width: 100%;
	overflow: hidden
}

.input-group input {
	position: relative;
	height: 90px;
	margin-left: 1px;
	margin-right: 1px;
	border-radius: 6px;
	padding-top: 30px;
	padding-left: 25px
}

.input-group label {
	position: absolute;
	height: 24px;
	background: none;
	border-radius: 6px;
	line-height: 48px;
	font-size: 15px;
	color: gray;
	width: 100%;
	font-weight: 100;
	padding-left: 25px
}

input:focus+label {
	color: #1E88E5
}

#qr {
	margin-bottom: 150px;
	margin-top: 50px
}
</style>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>
<%@include file="Header.jsp"%>



<form action="<%=DFViewCtl.PAYMENT_CTL%>" method="post">
		
		
<jsp:useBean id="bean" scope="request"
						class="ehealthcare.Bean.PaymentBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
					<input type="hidden" name="modifiedBy"
						value="<%=bean.getModifiedby()%>"> <input type="hidden"
						name="createdDatetime" value="<%=bean.getCreatedatetime()%>">
					<input type="hidden" name="modifiedDateTime"
						value="<%=bean.getModifieddatetime()%>">


	<div class="container-fluid px-0" id="bg-div">
		<div class="row justify-content-center">
			<div class="col-lg-9 col-12">
				<div class="card card0">
					<div class="d-flex" id="wrapper">
				
					
						<!-- Sidebar -->
								<!-- Page Content -->
						<div id="page-content-wrapper">
							<div class="row pt-3" id="border-btm">
								<div class="col-4">
								</div>
								
								<h3 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h3>
							<div class="tab-content">
								<div id="menu1" class="tab-pane">
									<div class="row justify-content-center">
										<div class="col-11">
											<div class="form-card">
												<h3 class="mt-0 mb-4 text-center">Enter bank details to pay</h3>
													<div class="row">
														<div class="col-md-12">
														</div>
													</div>
											</div>
										</div>
									</div>
								</div>
								<div id="menu2" class="tab-pane in active">
									<div class="row justify-content-center">
										<div class="col-11">
											<div class="form-card">
												<h3 class="mt-0 mb-4 text-center">Enter your Bank
													details to pay</h3>
													<div class="row">
														<div class="col-12">
															<div class="input-group">
																<input type="text" id="cr_no" value="<%=DataUtility.getStringData(bean.getCardnumber())%>"
																name="cardnumber"	placeholder="Name" 
																	maxlength="19"> <label>Account Name</label>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-6">
															<div class="input-group">
																<input type="text" id="exp" value="<%=DataUtility.getStringData(bean.getCardexpairy())%>"
																name="cardexpairy"	placeholder="IFSC"  maxlength="12">
																<label>IFSC</label>
															</div>
														</div>
														<div class="col-6">
															<div class="input-group">
																<input type="number"
														name="cvv"			placeholder="ACCOUNT NO" class="placeicon"  value="<%=DataUtility.getStringData(bean.getCvv())%>"
																	 maxlength="20"> <label>Account Number</label>
															</div>
														</div>
													</div>
													
													<div class="row">
													<div class="col-md-12">
            <input type="submit" class="btn btn-success"  name="operation" value="<%=PaymentCt.OP_PAY%>">
            </div>
          </div>
													
													
											</div>
										</div>
									</div>
								</div>
	
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</form>

	<%@include file="Footer.jsp"%>
</body>
</html>