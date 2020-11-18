
<!-- header -->

<%@page import="domaine.Etudiant"%>
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<!-- Début ajout etudiant -->

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	<ul>
		<li><a href="etudiant.jsp">Liste des étudiants</a></li>
	</ul>

	<!-- Masthead Heading-->
	<h1>Modifier un étudiant</h1>
	
	
	<div class="">
	
		<div class="pt-4 pb-3">
			<% Etudiant student = (Etudiant) session.getAttribute("student");%>
			<form action="ModifEtudiantServlet" method="post">

				<div class="form-row">
				
					<div class="col">
						<div class="md-form md-outline mt-0">
							<input type="text" id="firstName" name="firstName" class="form-control" value="<%=student.getFirst_name()%>"> 
							<label for="firstName">First Name</label>
						</div>
					</div>
					
					<div class="col">
						<div class="md-form md-outline mt-0">
							<input type="text" id="lastName" name="lastName" class="form-control" value="<%=student.getLast_name()%>"> 
							<label for="lastName">Last Name</label>
						</div>
					</div>
					
				</div>

				<div class="md-form md-outline mt-0">
					<input type="text" id="mailAdresse" class="form-control" name="mailAdresse" value="<%=student.getMail()%>"> 
					<label for="mailAdresse">Mail Adress</label>
				</div>
				
				
				<div class="md-form md-outline">
					<input  id="adress" class="form-control" name="adress" value="<%=student.getAddress()%>" >
					<label for="adress">Address</label>
				</div>
				
				<div class="md-form md-outline mt-0">
					<input type="text" id="numberPhone" name="numberPhone" class="form-control" value="<%=student.getPhone()%>">
					<label for="numberPhone">NumberPhone</label>
				</div>				
				
				<div class="md-form md-outline mt-0">
					<input type="date" id="dateOfBirth" name="dateOfBirth" class="form-control" value="<%=student.getDob()%>">
					<label for="dateOfBirth">Birth Date - format(yyyy-mm-dd)</label>
				</div>
				<div class="md-form md-outline mt-0"  style="visibility:hidden;">
					<input type="text" id="id" name="id" class="form-control" value="<%=student.getId()%>">
					<label for="id">id</label>
				</div>	
			
								
				<br/> <br/>
				<div class="text-center mb-2">
					<button type="submit" class="btn btn-primary mb-4">Submit</button>
				</div>

			</form>



		</div>

	</div>
	<!-- Card -->

</div>
<!-- Fin ajout etudiant -->

<!-- footer -->
<%@include file="footer.jsp"%>