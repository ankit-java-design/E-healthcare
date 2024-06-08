<%@page import="ehealthcare.Bean.PaymentBean"%>
<%@page import="ehealthcare.Controller.PaymentListCtl"%>
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
<title></title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
	<%
		UserBean bean1 = (UserBean) session.getAttribute("user");
	%>
		<div class="container mt-2"
		style="position: relative; min-height: 68vh">
	<h2 align="center">Payment History</h2>
	<br>
<div class="text-center">
		<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>
		</div>

	<form action="<%=DFViewCtl.PAYMENT_LIST_CTL%>" method="post">

		<table class="table table-striped">
			<tr>

				<th scope="col" style="color: blue">Name</th>
				<th scope="col" style="color: blue">IFSC</th>
				<th scope="col" style="color: blue">Account no</th>
				
					<%
				
					if (bean1.getRolename().equalsIgnoreCase("ADMIN")) {
				%>
				
			<th scope="col" style="color: blue">Action</th>
			<%}else{ %>
				
				<th scope="col" style="color: blue">Payment Done</th>
				<%} %>
			</tr>
			<%
				int index = 1;
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
				while (it.hasNext()) {
					PaymentBean bean = (PaymentBean) it.next();
			%>
			<tr>

				<td><%=bean.getCardnumber()%></td>
				<td><%=bean.getCardexpairy()%></td>
				<td><%=bean.getCvv()%></td>
				
					<%
				
					if (bean1.getRolename().equalsIgnoreCase("ADMIN")) {
				%>
				

				<td><a class="btn btn-danger"
					href="<%=DFViewCtl.PAYMENT_LIST_CTL%>?id=<%=bean.getId()%>">Delete</a></td>
<%}else{ %>
<td><a class="btn btn-info"
					href="">Paid</a></td>

<%} %>
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