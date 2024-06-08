<%@page import="ehealthcare.Controller.ContactCtl"%>
<%@page import="ehealthcare.Utility.DataUtility"%>
<%@page import="ehealthcare.Utility.ServletUtility"%>
<html lang="en">

<head>
<style>
.form-grp {
	margin-left: 400px;
}
</style>
<meta charset="UTF-8">
<meta name="author" content="Sahil Kumar">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Contact Us</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
</head>

<body>
	<%@ include file="Header.jsp"%>
	<br>
	<div class="container">

		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">

				<form action="<%=DFViewCtl.CONTACT_CTL%>" method="post">

					<h3 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h3>

					<jsp:useBean id="bean" scope="request"
						class="ehealthcare.Bean.ContactBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
					<input type="hidden" name="modifiedBy"
						value="<%=bean.getModifiedby()%>"> <input type="hidden"
						name="createdDatetime" value="<%=bean.getCreatedatetime()%>">
					<input type="hidden" name="modifiedDateTime"
						value="<%=bean.getModifieddatetime()%>">

					<div class="container">
						<div class="row justify-content-center">
							<div class="col-md-4 mt-5 bg-light rounded">
								<h1 class="text-center font-weight-bold text-primary">Contact
									Us</h1>
								<hr class="bg-light">
								<h5 class="text-center text-success"></h5>


								<div class="form-group input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fas fa-user"></i></span>
									</div>
									<input type="text" name="name" class="form-control"
										placeholder="Enter your name"
										value="<%=DataUtility.getStringData(bean.getName())%>">
									<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></div>
								</div>

								<div class="form-group input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fas fa-user"></i></span>
									</div>
									<input type="email" name="email" class="form-control"
										placeholder="Enter your email"
										value="<%=DataUtility.getStringData(bean.getEmail())%>">
									<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></div>
								</div>
								<div class="form-group input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fas fa-at"></i></span>
									</div>

									<input type="text" name="subject" class="form-control"
										placeholder="Enter subject"
										value="<%=DataUtility.getStringData(bean.getSubject())%>">
									<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("subject", request)%></div>
								</div>
								<div class="form-group input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="fas fa-comment-alt"></i></span>
									</div>
									<textarea name="message" id="msg" class="form-control"
										placeholder="Write your message" cols="30" rows="4"
										value="<%=DataUtility.getStringData(bean.getMessage())%>"></textarea>
									<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("message", request)%></div>
								</div>
							</div>
						</div>
					</div>

<br>
					<div class="form-grp">
						<input type="submit" class="btn btn-primary" class="send"
							name="operation" value="<%=ContactCtl.OP_SEND%>">
					</div>
				</form>
			</div>
		</div>

		<div class="col-2"></div>
	</div>



	<br>
	<%@ include file="Footer.jsp"%>
</body>
</html>