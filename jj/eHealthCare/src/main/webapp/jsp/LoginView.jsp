<%@page import="ehealthcare.Controller.LoginCtl"%>
<%@page import="ehealthcare.Bean.UserBean"%>
<%@page import="ehealthcare.Utility.ServletUtility"%>
<%@page import="ehealthcare.Controller.DFViewCtl"%>
<%@page import="ehealthcare.Utility.DataUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%@include file="Header.jsp"%>
<div class="container mt-2"
		style="position: relative; min-height: 68vh">
	<form action="<%=DFViewCtl.LOGIN_CTL%>" method="post">

		<jsp:useBean id="bean" scope="request"
			class="ehealthcare.Bean.UserBean" />

		<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
			type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
		<input type="hidden" name="modifiedBy"
			value="<%=bean.getModifiedby()%>"> <input type="hidden"
			name="createdDatetime" value="<%=bean.getCreatedatetime()%>">
		<input type="hidden" name="modifiedDateTime"
			value="<%=bean.getModifieddatetime()%>">

			<div class="row">
				<div class="col-2"></div>
				<div class="col-8" style="margin-top: 150px;">

<div class="text-center">
					<h4 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h4>
					<h4 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h4>
</div>

					<p class="h4 mb-4 text-center">Sign
						in<i class='fas fa-sign-in-alt' style='font-size:25px;color:teal; margin-left: 5px;'></i></p>
					<input type="email" id="defaultLoginFormEmail"
						class="form-control mb-4" name="email" placeholder="Enetr E-mail"
						value="<%=DataUtility.getStringData(bean.getEmail())%>">
					<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></div>


					<input type="password" id="defaultLoginFormPassword"
						class="form-control mb-4" name="password"
						placeholder="Enter Password"
						value="<%=DataUtility.getStringData(bean.getPassword())%>">
					<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></div>

<div class="text-center">
					<input type="submit" class="btn btn-primary" name="operation"
						value="<%=LoginCtl.OP_SINGIN%>">
						</div>
					<div>
						<div class="col-2"></div>
					</div>
					</div>
					</div>
	</form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>