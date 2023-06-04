function customLoginReset() {
	document.getElementById("username").value = "";
	document.getElementById("password").value = "";
}

function customRegisterReset() {

	document.getElementById("treatmentCommencementDate").value = "";
	document.getElementById("name").value = "";
	document.getElementById("age").value = "";
	document.getElementById("resultBox").innerHTML = "";
}

function showPassword()  {
			var show = document.getElementById('password')
			if (show.type == 'password') {
				show.type = 'text';
			} else {
				show.type = 'password';
			}
		}
		

function logout() {
  alert("Logged out!");
  
}

