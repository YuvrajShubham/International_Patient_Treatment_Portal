<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="side-navbar">
	<ul class="list-unstyled" id="pageSubmenu">
		<li><a href="/portal/user/specialists">Our Specialists</a></li>
		<li><a href="/portal/user/ipTreatmentPackages">Our Service Packages</a></li>
		<li><a href="/portal/user/ipTreatmentPackageByName">Search Package</a></li>
		<li><a href="/portal/user/treatmentRegister">Register</a></li>
<!-- 		<li><a href="/portal/user/trackTreatment">Track treatment</a></li> -->
<!--         <li><a href="/portal/getAllInsurerDetail">View Insurers</a></li> -->
<!-- 		<li><a href="/portal/logout">Logout</a></li> -->

<!--         <li><a href="/portal/logout"> <form onsubmit="return confirm('Do you really want to logout?');"> <button class="btn btn-reset" >Logout</button></form></a></li> -->
        <li><a href="/portal/logout"> <button class="btn btn-reset" onclick="logout()">Logout</button></a></li>
	</ul>

</div>
<!-- <script type="text/javascript"> -->
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