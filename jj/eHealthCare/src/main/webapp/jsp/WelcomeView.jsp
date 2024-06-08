<%@page import="ehealthcare.Controller.DFViewCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.btn{
position: absolute;
top: 50%;
left: 50%;
transform:translate(-50%,-50%);
 font-size: 16px;
 padding: 16px 30px;
 border: none;
 cursor: pointer;
 border-radius: 5px;
 text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%@include file="Header.jsp"%>

<%
		UserBean bean1 = (UserBean) session.getAttribute("user");
	%>
	
<div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
    
      <img src="<%=DFViewCtl.APP_CONTEXT%>/image/ThAOKju-doctor-wallpaper.jpg" class="d-block w-100" alt="..."  width="500" 
     height="700">
    <%--  <%
				
					if (bean1 == null) {
				%>
				<a class="btn btn-danger"
					href="<%=DFViewCtl.DOCTOR_VIEW_CTL%>">
   Find Doctor</a>
         
         <%
					} else {
				%>
				
				<%} %> --%>
    </div>
    <div class="carousel-item">
      <img src="<%=DFViewCtl.APP_CONTEXT%>/image/ThAOKju-doctor-wallpaper.jpg" class="d-block w-100" alt="..."  width="500" 
     height="700">
    <%--   <%
				
					if (bean1 == null) {
				%>
    <a class="btn btn-danger"
					href="<%=DFViewCtl.DOCTOR_VIEW_CTL%>">
   Find Doctor</a>
       <%
					} else {
				%>
				
				<%} %> --%>
    </div>
    <div class="carousel-item">
     <img src="<%=DFViewCtl.APP_CONTEXT%>/image/ThAOKju-doctor-wallpaper.jpg" class="d-block w-100" alt="..."  width="500" 
     height="700">
 <%--    <%
				
					if (bean1 == null) {
				%>
   <a class="btn btn-danger"
					href="<%=DFViewCtl.DOCTOR_VIEW_CTL%>">
   Find Doctor</a>
             <%
					} else {
				%>
				
				<%} %> --%>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<%@include file="Footer.jsp"%>

</body>
</html>