<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>International Patients Management System</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->




<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/style-table.css">
<link rel="stylesheet" href="/css/style-admin.css">
</head>

<body>

	<div class="main-container-register">

		<%@ include file="fragments/header.jsp"%>

		<div class="section grid">
		
			<%@ include file="admin-fragments/admin-sidebar.jsp"%>
			<div class="content list-container">
				<h1>Our In-patient Services</h1>
				<div class="container">
					<table class="table table-striped">
						<thead>
							<tr>
								<th rowspan="2">Id</th>
								<th rowspan="2">Ailment</th>
								<th colspan="4" class="left-border center">Package Details</th>
							</tr>
							<tr>
								<th class="left-border">Name</th>
								<th>Test detail</th>
								<th>Cost</th>
								<th>Duration in weeks</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${ipTreatmentPackageName}" var="p"
								varStatus="loop">
								<tr>
									
									<td>${p.getPackageDetail().getPid()}</td>
									<td>${p.getAilmentCategory()}</td>
									<td>${p.getPackageDetail().getTreatmentPackageName()}</td>
									<td>${p.getPackageDetail().getTestDetails()}</td>
									<td>${p.getPackageDetail().getCost()}</td>
									<td>${p.getPackageDetail().getTreatmentDuration()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	</div>
</body>

</html>