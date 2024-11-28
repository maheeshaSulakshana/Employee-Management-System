<%@ include file="layout/header.jsp" %>
<%@ page import="services.EmployeeServices" %>
<%@ page import="models.Employee" %>
<%@ page import="java.util.*" %>

<%
	Employee employee = (Employee) request.getAttribute("employee");
	String context = request.getContextPath();
	String path = (String) request.getAttribute("page");
	path = context.concat(path);
%>

<h1 style="position:relative;top:20px;left:570px;">Delete Employee</h1>
<div style="position:relative;top:50px;left:550px;">
<form action="<%= path %>" method="post" id='form-update'>
	<label>Employee ID: </label>
	<input type="text" name="id" id="id" value="<%= employee.getId() %>" style="position:relative;left:110px;"> <br><br>
	<label>Employee Name: </label>
	<input type="text" name="name" id="name" value="<%= employee.getName() %>" style="position:relative;left:84px;"/> <br><br>
	<label>Employee Address: </label>
	<input type="text" name="address" id="address" value="<%= employee.getAddress() %>"style="position:relative;left:67px;"/> <br><br>
	<label>Employee Telephone no: </label>
	<input type="text" name="teleNo" id="teleNo" value="<%= employee.getTelephoneNo() %>" style="position:relative;left:29px;"/> <br><br>
	<label>Employee DOB: </label>
	<input type="text" name="DOB" id="DOB" value="<%= employee.getDOB() %>" style="position:relative;left:92px;"> <br><br>
	<label>Gender: </label>
	<% if (employee.getGender().equals("male")){ %>
		<input type="radio" name="gender" id="rdbMale" value="male" checked>Male
	<% } else { %>
		<input type="radio" name="gender" id="rdbFemale" value="female" checked>Female
	<% } %> <br><br>
	<label>Designation: </label>
	<select name="designation" id="designation" style="position:relative;left:110px;width:190px;">
		<option value=""><%= employee.getDesignation() %></option>
		<option value="Manager">Manager</option>
		<option value="Clerk">Clerk</option>
		<option value="Trainee">Trainee</option>
	</select> <br><br>
	<button type="submit" id="button" class="btn btn-outline-success" style="position:relative;left:155px;">Delete</button>
</form>
</div>
<%@ include file="layout/footer.jsp" %>