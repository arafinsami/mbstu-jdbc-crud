<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>

	<div class="container" style="margin-top: 50px">
		<div class="row">
			<div class="col-md-6 col-offset-3">
				<form action="${path}/edit" method="post">
					<input type="hidden" name="id"
						value='<c:out value="${student.id}"/>' placeholder="Enter Name">
					<div class="form-group">
						<input type="text" class="form-control" name="name"
							value='<c:out value="${student.name}"/>' placeholder="Enter Name">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="email"
							value='<c:out value="${student.email}"/>'
							placeholder="Enter Email">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="address"
							value='<c:out value="${student.address}"/>'
							placeholder="Enter Addresss">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

