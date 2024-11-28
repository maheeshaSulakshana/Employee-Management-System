<%@ include file="layout/header.jsp" %>
<%@ page import="services.EmployeeServices" %>
<%@ page import="java.util.*" %>

<div style="position:relative; top:90px;">
<h1 style="position:relative;top:20px;left:440px;">Select Employee ID to get Details</h1>

<%
	String context = request.getContextPath();
	String path = context + (String) request.getAttribute("page");
%>
<div style="position:relative;top: 70px;left:500px;">
<form action="<%= path %>" method="post">
	<label style="position:relative;left:100px;">Employee ID: </label>
	<select required name="id" id="id" style="position:relative;left:100px;">
		<option value="">Please select an ID</option>
		<%
			EmployeeServices employeeServices = new EmployeeServices();
			List<Integer> IDs = employeeServices.getAllIds();
			for (Integer ID:IDs){
		%>
				<option value="<%= ID %>"><%= ID %></option>
		<%	
		}
		%>
	</select>
	<input type="text" style="visibility:hidden;" name="name" value=""> <br><br>
	<button type="submit" id="button" style="position:relative;left:198px;" class="btn btn-outline-success">Get Details</button>
</form>
</div>
</div>

<%@ include file="layout/footer.jsp" %>