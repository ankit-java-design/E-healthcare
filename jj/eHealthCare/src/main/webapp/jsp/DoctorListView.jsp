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
<title>Doctor List</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
	<div class="container mt-2"
		style="position: relative; min-height: 68vh">
	<h2 align="center">Doctor List</h2>
	<br>
<div class="text-center">
		<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>
		</div>

	<form action="<%=DFViewCtl.DOCTOR_LIST_CTL%>" method="post">

		<table width="100%">
			<tr>
				<td align="center"><label style="color: blue"> 
						Specialty :</label> <input type="text" name="location" placeholder="Enter Specialty"
					value="<%=ServletUtility.getParameter("name", request)%>">
					&emsp;&emsp; <input type="submit" name="operation"
					style="color: blue" value="<%=DoctorListCtl.OP_SEARCH%>">&nbsp;&nbsp;&nbsp;<input
					type="submit" style="color: blue" name="operation"
					value="<%=DoctorListCtl.OP_RESET%>"></td>
			</tr>
		</table>
		<br>

		<table class="table table-striped">
			<tr>

				<th scope="col">Doctor Name</th>
				<th scope="col">Email</th>
				<th scope="col">Location</th>
				<th scope="col">Gender</th>
				<th scope="col">Specialty</th>
				<th scope="col">From</th>
				<th scope="col">To</th>
				<th scope="col">Fees</th>
				<th scope="col">Experience</th>
				<th scope="col">Action</th>
				<th scope="col"></th>
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
				
				
				<td><a class="btn btn-info"
					href="<%=DFViewCtl.DOCTOR_CTL%>?id=<%=bean.getId()%>"><i class='fas fa-edit' style='font-size:16px;'></i></a></td>
				<td><a class="btn btn-danger"
					href="<%=DFViewCtl.DOCTOR_LIST_CTL%>?id=<%=bean.getId()%>"><i class='	far fa-trash-alt' style='font-size:16px;'></i></a></td>
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