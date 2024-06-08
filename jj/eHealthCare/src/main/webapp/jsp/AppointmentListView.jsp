<%@page import="ehealthcare.Controller.AppointmentCtl"%>
<%@page import="ehealthcare.Bean.AppointmentBean"%>
<%@page import="ehealthcare.Bean.DoctoreBean"%>
<%@page import="ehealthcare.Controller.DoctorListCtl"%>
<%@page import="ehealthcare.Utility.ServletUtility"%>
<%@page import="ehealthcare.Controller.DFViewCtl"%>
<%@page import="ehealthcare.Utility.DataUtility"%>
<%@page import="ehealthcare.Utility.HTMLUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment List</title>
</head>
<body>
<%@include file="Header.jsp"%>
	<br>
	<div class="container mt-2"
		style="position: relative; min-height: 68vh">
	<h2 align="center">Appointment List</h2>
	<br>
<%
		UserBean bean1 = (UserBean) session.getAttribute("user");
	%>
	
<div class="text-center">
		<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>
		</div>

	<form action="<%=DFViewCtl.APPOINTMENT_LIST_CTL%>" method="post">

		<%-- <table width="100%">
			<tr>
				<td align="center"><label style="color: blue"> Patient
						Name :</label> <input type="text" name="patient" placeholder="Enter Patient Name"
					value="<%=ServletUtility.getParameter("name", request)%>">
					&emsp;&emsp; <input type="submit" name="operation"
					style="color: blue" value="<%=AppointmentCtl.OP_SEARCH%>">&nbsp;&nbsp;&nbsp;<input
					type="submit" style="color: blue" name="operation"
					value="<%=AppointmentCtl.OP_RESET%>"></td>
			</tr>
		</table> --%>
		<br>

		<table class="table table-striped">
			<tr>

				<th scope="col">Doctor Name</th>
				<th scope="col">Patient Name</th>
				<th scope="col">Disease</th>
				<th scope="col">Appointment Date</th>
				<th scope="col">Appointment Time</th>
				<th scope="col">Appointment Description</th>
					<%
				
					if (bean1.getRolename().equalsIgnoreCase("ADMIN")) {
				%>
				
				<th scope="col">Action</th>
				<th scope="col"></th>
				<th scope="col"></th>
				
				<%
					} else {
						
				%>
				<th scope="col">Pay</th>
				<% }%>
				
				
			</tr>
			<%
				int index = 1;
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
				while (it.hasNext()) {
					AppointmentBean bean = (AppointmentBean) it.next();
			%>
			<tr>

				<td><%=bean.getDoctorName()%></td>
				<td><%=bean.getPatientname()%></td>
				<td><%=bean.getDisease()%></td>
				<td><%=bean.getAppointmentdate()%></td>
				<td><%=bean.getAppointmenttime()%></td>
				<td><%=bean.getAppointmentdescription()%></td>
				
					
					
				<%
				
					if (bean1.getRolename().equalsIgnoreCase("ADMIN")) {
				%>
				
				<td><a class="btn btn-danger"
					href="<%=DFViewCtl.APPOINTMENT_LIST_CTL%>?id=<%=bean.getId()%>">Delete</a></td>
					<td><a class="btn btn-success"
					href="<%=DFViewCtl.APPOINTMENT_LIST_CTL%>?Cid=<%=bean.getId()%>">Confirm</a></td>
					<td><a class="btn btn-warning"
					href="<%=DFViewCtl.APPOINTMENT_LIST_CTL%>?Rid=<%=bean.getId()%>">Cancel</a></td>
					
					<%
					} else {
				%>
				<%if(bean.getStatus().equalsIgnoreCase("Confirm")){ %>
				<%if(bean.getStatus().equalsIgnoreCase("Paid")){ %>
					<td><a class="btn btn-success"
					href=""><%=bean.getStatus()%></a></td>
				<%}else{ %>
				<td><a class="btn btn-info"
					href="<%=DFViewCtl.PAYMENT_CTL%>?Pid=<%=bean.getId()%>"><i class='fab fa-amazon-pay' style='font-size:15px;'></i></a></td>
					<%} %>
					<% }else{%>
					<td><a class="btn btn-warning"
					href=""><%=bean.getStatus()%></a></td>
				<%} }%>
				
			</tr>
			<%
				}
			%>
			</tbody>
		</table>


	</form>
	</div>
<%@include file="Footer.jsp"%>
</body>
</html>