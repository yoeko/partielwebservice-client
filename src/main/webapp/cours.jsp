<%@page import="domaine.Cours"%>
<%@page import="domaine.Etudiant"%>

<%@page import="java.util.List"%>
<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	<!-- Masthead Heading-->
	<h1>Liste des cours</h1>

	<div class="table-responsive text-nowrap">
		<!--Table-->

		<table class="table table-striped" id="paginationFull">

			<!--Table head-->
			<thead>
				<tr>
					<th>#</th>
					<th>Désignation</th>
					<th>Heures</th>
				</tr>
			</thead>
			<!--Table head-->

			<!--Table body-->
			<tbody>
				<%
					List<Cours> listeCourse = (List<Cours>) session.getAttribute("courses");
				%>
				<%
					int i = 0;
				%>
				<%
					for (Cours course : listeCourse) {
				%>
				<%
					
				%>
				<tr>
					<td scope="row">
						<%
							i++;
						%>
					</td>
					<td><%=course.getThemeCourse()%></td>
					<td><%=course.getNumberHours()%></td>
					
					
				</tr>
				<%
					}
				%>
			</tbody>
			<!--Table body-->


		</table>
		<!--Table-->
	</div>
	

	<!--Section: Live preview-->

</div>




<!-- footer -->
<%@include file="footer.jsp"%>