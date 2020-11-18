<%@page import="domaine.Cours"%>
<%@page import="domaine.Etudiant"%>

<%@page import="java.util.List"%>
<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
<br/><br/><br/><br/><br/><br/>
	<%List<Cours> listCours = (List<Cours>) session.getAttribute("cours");%>
	<h1>Associé un cour a un etudiant</h1>
	<form action="EtudiantCoursServlet" method="post">
	<br/><br/>
	<% Etudiant student = (Etudiant) session.getAttribute("student");%>
	
		<input type="text" id="mail" class="form-control" name="mail" value="<%=student.getMail()%>">
		
		<br/><br/>
		
	  	<select name="listeCours" class="browser-default custom-select">
				<% 
				        for (Cours course : listCours)
				        {
				         
				%>
					   <option name="cours" value="<%=course.getThemeCourse()%>"><%=course.getThemeCourse()%></option>
				<%
				        }
				%>
		</select>
			<br/> <br/>
			<div class="text-center mb-2">
					<button type="submit" class="btn btn-primary mb-4">Submit</button>
			</div>
</div>

<!-- footer -->
<%@include file="footer.jsp"%>