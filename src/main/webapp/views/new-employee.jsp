<%@ include file="layout/header.jsp" %>

<h1 style="position:relative;top:50px;left:620px;">Insert Employee</h1>

<div style="position:relative;top: 100px;left:580px;">
	<form action="<%= request.getContextPath() %>/new" method="post" id='form'>
		<label>Employee Name:</label>
		<input type="text" name="name" id="name" style="position:relative;left:60px;">/> <br><br>
		<label>Employee Address:</label>
		<input type="text" name="address" id="address" style="position:relative;left:44px;"/> <br><br>
		<label>Employee Telephone no:</label>
		<input type="text" name="teleNo" id="teleNo" style="position:relative;left:6px;"/> <br><br>
		<label>Employee DOB:</label>
		<input type="text" name="DOB" id="DOB" style="position:relative;left:70px;"> <br><br>
		<label>Gender:</label>
		<input type="radio" name="gender" id="rdbMale" value="male">Male
		<input type="radio" name="gender" id="rdbFemale" value="female">Female <br><br>
		<label>Designation:</label>
		<select required name="designation" id="designation" style="position:relative;left:90px;width:190px;">
			<option value="">Please select a value</option>
			<option value="Manager">Manager</option>
			<option value="Clerk">Clerk</option>
			<option value="Trainee">Trainee</option>
		</select> <br><br>
		<button type="button" id="button" class="btn btn-outline-success" style="position:relative;left:155px;">Save</button>
	</form>
<div>
<script>
	let form = document.getElementById('form');
	let txtname = document.getElementById('name');
	let adderss = document.getElementById('address');
	let telephoneNo = document.getElementById('teleNo');
	let dob = document.getElementById('DOB');
	let rdbmale = document.getElementById('rdbMale');
	let rdbfemale = document.getElementById('rdbFemale')
	let designation = document.getElementById('designation');
	let button = document.getElementById('button');
	
	button.onclick = function(){
		//validations
		if (txtname.value == "" || txtname.length == 0){
			alert("Must enter Employee name");
			return;
		}
		if (address.value == "" || adderss.length == 0){
			alert("Must enter Employee address");
			return;
		}
		if (telephoneNo.value.length != 10){
			alert("Telephone no must be 10 numbers");
			return;
		}
		if (dob.value == "" || dob.length == 0){
			alert("Must enter Employee DOB");
			return;
		}
		if (rdbMale.checked == false && rdbFemale.checked == false){
			alert("Must select gender");
			return;
		}
		if (designation.value == ""){
			alert("Must select Designation");
			return;
		}
		
		form.submit();
	}
</script>

<%@ include file="layout/footer.jsp" %>