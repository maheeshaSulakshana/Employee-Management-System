<%@include file="layout/header.jsp" %>
<%@page import="models.Employee" %>

<h1 style="position:relative;left:600px;">Employee Details</h1>

<table border="1" cellspacing="0px" cellpadding="5px" align="center" width="80%">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Address</th>
		<th>Telephone No</th>
		<th>DOB</th>
		<th>Gender</th>
		<th>Designation</th>
	</tr>
	
<%
	Employee employee = (Employee) request.getAttribute("employee");
%>	
	<tr>
		<td><%= employee.getId() %></td>
		<td><%= employee.getName() %></td>
		<td><%= employee.getAddress() %></td>
		<td><%= employee.getTelephoneNo() %></td>
		<td><%= employee.getDOB() %></td>
		<td><%= employee.getGender() %></td>
		<td><%= employee.getDesignation() %></td>
	</tr>

</table>
<a href="<%= request.getContextPath() %>/"><button style="position:relative;top:10px;left:675px;" class="btn btn-outline-secondary">Click here to go back</button></a>
<%@include file="layout/footer.jsp" %>