<%@page import="domaine.Etudiant"%>
<%@page import="java.util.List"%>

<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	
	<!-- Masthead Heading-->
	<h1>Les informations de l'étudiant</h1>

	<div class="table-responsive text-nowrap">
		<!--Table-->
		<% Etudiant student = (Etudiant) session.getAttribute("student"); %>
		Id        	 : <%=student.getId()%>
		<br/><br/>
		First Name	 : <%=student.getFirst_name()%>
		<br/><br/>
		Last Name 	 : <%=student.getLast_name()%>
		<br/><br/>
		Mail Address : <%=student.getMail()%>
		<br/><br/>
		Address		 : <%=student.getAddress()%>
		<br/><br/>
		Phone Number : <%=student.getPhone()%>
		<br/><br/>
		BirthDay	 : <%=student.getDob()%>

	</div>

	<!--Section: Live preview-->

</div>




<!-- footer -->
<script>

</script>
<%@include file="footer.jsp"%>