<%@page import="ehealthcare.Controller.UserCtl"%>
<%@page import="ehealthcare.Controller.RegistrationCtl"%>
<%@page import="ehealthcare.Controller.LoginCtl"%>
<%@page import="ehealthcare.Bean.UserBean"%>
<%@page import="ehealthcare.Utility.ServletUtility"%>
<%@page import="ehealthcare.Controller.DFViewCtl"%>
<%@page import="ehealthcare.Utility.DataUtility"%>
<%@page import="ehealthcare.Utility.HTMLUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
	$('.datepicker').datepicker();
</script>
<style>
.btn{
	margin-left: 400px;
}
</style>
<meta charset="ISO-8859-1">
<title>USer</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div class="container">
		<br>
		
		<div class="text-center">
		<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>
		</div>
		<form action="<%=DFViewCtl.USER_CTL%>" method="post">

			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">


					<jsp:useBean id="bean" scope="request"
						class="ehealthcare.Bean.UserBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
					<input type="hidden" name="modifiedBy"
						value="<%=bean.getModifiedby()%>"> <input type="hidden"
						name="createdDatetime" value="<%=bean.getCreatedatetime()%>">
					<input type="hidden" name="modifiedDateTime"
						value="<%=bean.getModifieddatetime()%>">
					<%
						ServletUtility.getList(request);
					%>
					<%
						if (bean.getId() > 0) {
					%>
					<h1 align="center">Update User</h1>
					<%
						} else {
					%>
					<h1 align="center">Add User</h1>
					<%
						}
					%>
					<div class="mb-3">
						<label class="form-label">Name</label> <input type="text"
							class="form-control" name="name" placeholder="Enter Name here..."
							value="<%=DataUtility.getStringData(bean.getName())%>">

						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></div>
					</div>

					<div class="mb-3">
						<label class="form-label">Email Id</label> <input type="text"
							class="form-control" name="email"
							placeholder="Enter Email Id here..."
							value="<%=DataUtility.getStringData(bean.getEmail())%>">

						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></div>
					</div>
					<div class="mb-3">
						<label class="form-label">Password</label> <input type="password"
							class="form-control" name="password"
							placeholder="Enter Password here..."
							value="<%=DataUtility.getStringData(bean.getPassword())%>">

						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></div>
					</div>

					<div class="mb-3">
						<label class="form-label">PhoneNo</label> <input type="text"
							class="form-control" name="phoneNo"
							placeholder="Enter Phone No here..."
							value="<%=DataUtility.getStringData(bean.getPhoneNo())%>">

						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("phoneNo", request)%></div>
					</div>


					<%
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("Male", "Male");
						map.put("Female", "Female");
					%>

					<div class="mb-3">
						<label class="form-label">Gender</label>
						<%=HTMLUtility.getList("gender", String.valueOf(bean.getGender()), map)%>
						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("gender", request)%></div>
					</div>
					<label for="form_message">Date-Of-Birth :</label>

					<div class="form-group">
						<input type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name="dob" id="datepicker"
							data-provide="datepicker"
							value="<%=DataUtility.getStringData(bean.getDob())%>"
							placeholder="date Enter Here"> <font color="red"><%=ServletUtility.getErrorMessage("dob", request)%></font>
					</div>
<br>
		<div class="text-center">
					<%
						if (bean.getId() > 0) {
					%>
					<input type="submit" class="btn btn-primary" name="operation"
						value="<%=UserCtl.OP_UPDATE%>">
					<%
						} else {
					%>
					<input type="submit" class="btn btn-primary" name="operation"
						value="<%=UserCtl.OP_SAVE%>">
					<%
						}
					%>
</div>
				</div>
				<div class="col-2"></div>

			</div>
		</form>
	</div>
	<br>
	<%@ include file="Footer.jsp"%>
</body>
</html>