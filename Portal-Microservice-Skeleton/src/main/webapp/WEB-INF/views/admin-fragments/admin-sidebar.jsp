<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="side-navbar">
	<ul class="list-unstyled" id="pageSubmenu">
	<li><a href="/portal/specialists">View All Specialists</a></li>
		<li><a href="/portal/addSpecialist">Add / Update Specialist</a></li>
		<li><a href="/portal/deleteSpecialistById">Delete Specialist</a></li>
		<li><a href="/portal/viewSpecialistsByExpertise">View Specialists By Expertise</a></li>
		<li><a href="/portal/ipTreatmentPackages">Our Service Packages</a></li>
		<li><a href="/portal/ipTreatmentPackageByName">Search All Packages</a></li>
		<li><a href="/portal/treatmentRegister">Register Patient</a></li>
		<li><a href="/portal/trackTreatment">View Treatment Plan</a></li>
		<li><a href="/portal/adminViewActivePage">View Active Users</a></li>
		<li><a href="/portal/adminViewInactivePage">View InActive Users</a></li>
		<li><a href="/portal/getAllInsurerDetail">View Insurers</a></li>
		<li><a href="/portal/logout" onclick="logout()">Logout</a></li>
<!-- 		<li><a href="/portal/logout"> <button class="btn btn-reset" onclick="logout()">Logout</button></a></li> -->
<!-- 	       <li><a href="/portal/logout"> <form onsubmit="return confirm('Do you really want to logout?');"> <button class="btn btn-reset" >Logout</button></form></a></li> -->
<!--         <li><a href="/portal/logout"> <button class="btn btn-reset" onclick="logout()">Logout</button></a></li> -->
	</ul>

</div>
<!-- <script type="text/javascript" src="/js/script.js"> -->
<!-- // function validate(form) { -->

<!-- //     // validation code here ... -->


<!-- //     if(!valid) { -->
<!-- //         alert('Please correct the errors in the form!'); -->
<!-- //         return false; -->
<!-- //     } -->
<!-- //     else { -->
<!-- //         return confirm('Do you really want to logout?'); -->
<!-- //     } -->
<!-- // } -->

<!-- </script> -->
<script src="/js/script.js"></script>