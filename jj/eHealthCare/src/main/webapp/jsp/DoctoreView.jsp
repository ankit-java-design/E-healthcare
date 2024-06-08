<%@page import="ehealthcare.Controller.DoctoreCtl"%>
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
<style>
.btn{
	margin-left: 400px;
}
</style>
<meta charset="ISO-8859-1">
<title>Doctor</title>
</head>
<body>
<%@ include file= "Header.jsp"%>
	<div class="container">
		<br>
		
		
		<hr>
		<form action="<%=DFViewCtl.DOCTOR_CTL%>" method="post">

			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
<div class="text-center">
		<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>
		</div>

					<jsp:useBean id="bean" scope="request"
						class="ehealthcare.Bean.DoctoreBean" />

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
					<h1 align="center">Update Doctor</h1>
					<%
						} else {
					%>
					<h1 align="center">Add Doctor</h1>
					<%
						}
					%>


					<div class="mb-3">
						<label class="form-label">Name</label> <input type="text"
							class="form-control" name="name"
							placeholder="Enter Name here..."
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
						<label class="form-label">Location</label> <input type="text"
							class="form-control" name="location"
							placeholder="Enter  Location here..."
							value="<%=DataUtility.getStringData(bean.getLocation())%>">

						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("location", request)%></div>
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
					
					
<div class="mb-3">
						<label class="form-label">Specialty</label> <input type="text"
							class="form-control" name="category"
							placeholder="Enter Specialty here..."
							value="<%=DataUtility.getStringData(bean.getCategory())%>">

						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("category", request)%></div>
					</div>

<div class="mb-3">
						<label class="form-label">Fees</label> <input type="text"
							class="form-control" name="fees"
							placeholder="Enter Fees here..."
							value="<%=DataUtility.getStringData(bean.getFees())%>">

						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("fees", request)%></div>
					</div>
					
					<div class="mb-3">
						<label class="form-label">Experience</label> <input type="text"
							class="form-control" name="experience"
							placeholder="Enter Experience here..."
							value="<%=DataUtility.getStringData(bean.getExperience())%>">

						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("experience", request)%></div>
					</div>
					
<div class="mb-3">
	 <label for="appt">From:</label> <input
			type="time"  class="form-control" name="from" value="<%=bean.getFrom()%>"  required>
			</div>
<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("from", request)%></div>

<div class="mb-3">
	 <label for="appt">To:</label> <input
			type="time"  class="form-control" name="to" value="<%=bean.getTo()%>"  required>
			</div>
<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("to", request)%></div>

					<%
						if (bean.getId() > 0) {
					%>
					<input type="submit" class="btn btn-primary" name="operation" 
						value="<%=DoctoreCtl.OP_UPDATE%>">
					<%
						} else {
					%>
					<input type="submit" class="btn btn-primary" name="operation"
						value="<%=DoctoreCtl.OP_SAVE%>">
					<%
						}
					%>

				</div>
				<div class="col-2"></div>

			</div>
		</form>
	</div>
	<br>
	<%@ include file="Footer.jsp"%>
</body>
</html>