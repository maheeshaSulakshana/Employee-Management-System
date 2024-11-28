<%@ include file="layout/header.jsp" %>

<div style="position:relative;top:80px;">
<h1 style="position:relative;left:400px;">Welcome to the Employee Management Page</h1>

<div style="position:relative;top:40px;">
<a href="<%= request.getContextPath() %>/new"><button class="btn btn-outline-success btn-lg" style="position:relative;top:40px;left:440px;">Click here to add a New Employee</button></a> <br><br>
<a href="<%= request.getContextPath() %>/update"><button class="btn btn-outline-success btn-lg" style="position:relative;bottom:32px;left:790px;">Click here to Update Employee Details</button></a> <br><br>
<a href="<%= request.getContextPath() %>/delete"><button class="btn btn-outline-success btn-lg" style="position:relative;left:450px;">Click here to Delete an Employee</button></a> <br><br>
<a href="<%= request.getContextPath() %>/search"><button class="btn btn-outline-success btn-lg" style="position:relative;bottom:72px;left:790px;">Click here to Search for an Employee</button></a> <br><br>
<a href="<%= request.getContextPath() %>/view"><button class="btn btn-outline-success btn-lg" style="position:relative;bottom:72px;left:620px;">Click here to View Employee Details</button></a>
</div>

</div>
<%@ include file="layout/footer.jsp" %>