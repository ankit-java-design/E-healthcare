<%@page import="ehealthcare.Bean.DoctoreBean"%>
<%@page import="ehealthcare.Controller.DoctorList"%>
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
<title>Doctor List</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
	<%UserBean user = (UserBean)session.getAttribute("user");%>
	<div class="container mt-2"
		style="position: relative; min-height: 68vh">
	<h2 align="center">Doctor List</h2>
	<br>

	<h4 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h4>
	<h4 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h4>

	<form action="<%=DFViewCtl.DOCTOR_VIEW_CTL%>" method="post">

		<table width="100%">
			<tr>
				<td align="center"><label style="color: blue">
						Doctor :</label> <input type="text" name="name" placeholder="Enter Doctor Name"
					value="<%=ServletUtility.getParameter("name", request)%>">
					&emsp;&emsp; <input type="submit" name="operation"
					style="color: blue" value="<%=DoctorList.OP_SEARCH%>">&nbsp;&nbsp;&nbsp;<input
					type="submit" style="color: blue" name="operation"
					value="<%=DoctorList.OP_RESET%>"></td>
			</tr>
		</table>
		<br>

		<table class="table table-striped">
			<tr>
				<th scope="col" style="color: blue">Doctor Name</th>
				<th scope="col" style="color: blue">Email</th>
				<th scope="col" style="color: blue">Location</th>
				<th scope="col" style="color: blue">Gender</th>
				<th scope="col" style="color: blue">Specialty</th>
				<th scope="col" style="color: blue">From</th>
				<th scope="col" style="color: blue">To</th>
				<th scope="col" style="color: blue">Fees</th>
				<th scope="col" style="color: blue">Experience</th>
				<th scope="col" style="color: blue">Appointment Book</th>
			</tr>
			<%
				int index = 1;
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
				while (it.hasNext()) {
					DoctoreBean bean = (DoctoreBean) it.next();
			%>
			<tr>
				<td><%=bean.getName()%></td>
				<td><%=bean.getEmail()%></td>
				<td><%=bean.getLocation()%></td>
				<td><%=bean.getGender()%></td>
				<td><%=bean.getCategory()%></td>
				<td><%=bean.getFrom()%></td>
			    <td><%=bean.getTo()%></td>
				<td><%=bean.getFees()%></td>
				<td><%=bean.getExperience()%></td>
				
				<%-- <%if(bean.getStatus().equalsIgnoreCase("status")|| user.getId()==bean.getUserid()){ %> --%>
				<td><a class="btn btn-info"
					href="<%=DFViewCtl.APPOINTMENT_CTL%>?name=<%=bean.getName()%>&Bid=<%=bean.getId()%>"><i class='fas fa-book-medical' style='font-size:22px;color:teal;margin-right: 5px;'></i></a></td>
				<%-- <%}else{ %>
					<td><a class="btn btn-secondary"
					href="">Booked</a></td>
				<%} %> --%>
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