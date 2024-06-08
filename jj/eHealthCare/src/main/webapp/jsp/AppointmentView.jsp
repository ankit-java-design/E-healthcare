<%@page import="ehealthcare.Controller.AppointmentCtl"%>
<%@page import="ehealthcare.Utility.ServletUtility"%>
<%@page import="ehealthcare.Controller.DFViewCtl"%>
<%@page import="ehealthcare.Utility.DataUtility"%>
<%@page import="ehealthcare.Utility.HTMLUtility"%>
<%@page import="ehealthcare.Utility.JDBCDataSource"%>
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
.custom-select{
width: 100%; 
height: 35px;
}

</style>
<meta charset="ISO-8859-1">
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
<title>Appointment</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<%
	UserBean user = (UserBean)session.getAttribute("user");
	%>
		<br>
		<h2 align="center">Appointment Book</h2>
		
		<hr>
		<form action="<%=DFViewCtl.APPOINTMENT_CTL%>" method="post">
		<div class="container">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8"   align="center">
<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>

					<jsp:useBean id="bean" scope="request"
						class="ehealthcare.Bean.AppointmentBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
					<input type="hidden" name="modifiedBy"
						value="<%=bean.getModifiedby()%>"> <input type="hidden"
						name="createdDatetime" value="<%=bean.getCreatedatetime()%>">
					<input type="hidden" name="modifiedDateTime"
						value="<%=bean.getModifieddatetime()%>">

<div class="col-6">
		<%-- 					<label for="form-label">Doctor:</label>
							<div class="form-group">
								<select class="custom-select" name=doctor>
									<%
										Connection con = JDBCDataSource.getConnection();
										String sql = "SELECT * FROM doctor";
										PreparedStatement ps = con.prepareStatement(sql);
										ResultSet rs = ps.executeQuery();
										while (rs.next()) {
									%>
									<option value="--------Select--------"></option>
									<option value="<%=rs.getLong(1)%>"><%=rs.getString(2)%></option>

									<%
										}
									%>
								</select>
								</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("doctor", request)%></div>
 --%>

<label class="form-label">Doctor Name</label> <input type="text"
							class="form-control" name="doctor" readonly="readonly"
							placeholder="Enter Name here..."
							value="<%=DataUtility.getStringData(bean.getDoctor())%>">
						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("doctor", request)%></div>




						<label class="form-label">Patient Name</label> <input type="text"
							class="form-control" name="patientname"
							placeholder="Enter Name here..." readonly="readonly"
							value="<%=DataUtility.getStringData(user.getName())%>">
						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></div>



						<label class="form-label">Disease</label> <input type="text"
							class="form-control" name="disease"
							placeholder="Enter Disease here..."
							value="<%=DataUtility.getStringData(bean.getDisease())%>">
						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("disease", request)%></div>



						<label for="form_message">Appointment-Date :</label>
						<div class="form-group">
							<input type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="date" id="datepicker"
								data-provide="datepicker"
								value="<%=DataUtility.getStringData(bean.getAppointmentdate())%>"
								placeholder="date Enter Here"> <font color="red"><%=ServletUtility.getErrorMessage("date", request)%></font></div>



		<label class="form-label">Appointment-Description</label> <textarea
							class="form-control" name="description"
							placeholder="Write your Description" cols="55" rows="3">
							<%=DataUtility.getStringData(bean.getAppointmentdescription())%></textarea>
						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("description", request)%></div>



					<%-- <label for="form_message">Appointment-Description:</label>
					<textarea name="description" class="form-Center"
						placeholder="Write your Description" cols="55" rows="3"
						value="<%=DataUtility.getStringData(bean.getAppointmentdescription())%>"></textarea>
					<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("description", request)%></div> --%>
					
					
						<label for="form_message">Appointment-Time:</label> 
						<div class="form-group">
						<input type="time" class="form-control" name="time" value="<%=bean.getAppointmenttime()%>" required>
					</div>
					
					
					<br>
					<input type="submit" class="btn btn-primary" name="operation"
						value="<%=AppointmentCtl.OP_SAVE%>">
						
						
						
						</div>
			<div class="col-2"></div>
	</div>
	</div>
	</div>
	</form>

<br>
	<%@ include file="Footer.jsp"%>
</body>
</html>