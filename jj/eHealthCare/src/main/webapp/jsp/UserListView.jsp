<%@page import="ehealthcare.Controller.UserListCt"%>
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
<%@page import="java.util.Iterator"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserList</title>
</head>
<body>
	<%@include file="Header.jsp"%>
<div class="container">
	<br>
	<h2 align="center">User List</h2>
	<br>

	<form action="<%=DFViewCtl.USER_LIST_CTL%>" method="post">

		<table width="100%">
			<tr>
				<td align="center"><label> Name :</label> <input type="text"
					name="name" placeholder="Enter Name"
					value="<%=ServletUtility.getParameter("name", request)%>">
					&emsp;&emsp; <input type="submit" name="operation"
					value="<%=UserListCt.OP_SEARCH%>">&nbsp;&nbsp;&nbsp;<input
					type="submit" name="operation" value="<%=UserListCt.OP_RESET%>"></td>
			</tr>
		</table>
		<br>
		<div class="text-center">
	<h4 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h4>
	<h4 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h4>
</div>

		<table class="table table-striped">
			<tr>

				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">PhoneNo</th>
				<th scope="col">Gender</th>
				<th scope="col">Date-Of-Birth</th>
				<th scope="col">RoleName</th>
				<th scope="col">Action</th>
				<th scope="col"></th>
			</tr>
			<%
				int index = 1;
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>
			<tr>

				<th scope="row"><%=index++%></th>
				<td><%=bean.getName()%></td>
				<td><%=bean.getEmail()%></td>
				<td><%=bean.getPhoneNo()%></td>
				<td><%=bean.getGender()%></td>
				<td><%=bean.getDob()%></td>
<td><%=bean.getRolename()%></td>
				<%
				
					if (bean.getRolename().equalsIgnoreCase("ADMIN")) {
				%>
				<td>-------</td>
				
				<%
					} else {
				%>
				
			<%-- 	<td><a class="btn btn-info"
					href="<%=DFViewCtl.USER_CTL%>?id=<%=bean.getId()%>"><i
						class='fas fa-edit' style='font-size: 15px;'></i></a></td>
 --%>

				<td><a class="btn btn-danger"
					href="<%=DFViewCtl.USER_LIST_CTL%>?id=<%=bean.getId()%>"><i
						class='	far fa-trash-alt' style='font-size: 15px;'></i></a></td>
				<%
					}
				%>



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
</body>
</html>