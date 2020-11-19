package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import domaine.Etudiant;
import domaine.User;

/**
 * Servlet implementation class AjoutEtudiantServlet
 */
//@WebServlet("/AjoutEtudiant")
public class AjoutEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private EtudiantService studentService;
	private RequestDispatcher dispatcher = null;
//	private CoursService courseService;
	private User user = null;
//	private IEtudiantDao etudiantDao = new EtudiantDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutEtudiantServlet() {
//		studentService = new EtudiantService(etudiantDao);
//		courseService = new CoursService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Etudiant student = new Etudiant(request.getParameter("firstName"), request.getParameter("lastName"),
				request.getParameter("mailAdresse"), request.getParameter("adress"),
				request.getParameter("numberPhone"), new Date());

		HttpSession session = request.getSession();
		session.setAttribute("student", null);
		user = (User) session.getAttribute("user");
		
		
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(student);
		
		WebResource webResource = client.resource("http://localhost:8080/partielwebservice-webservice/rest/json/student/create");

		ClientResponse response2 = webResource.type("application/json").post(ClientResponse.class, jsonString);
		
		
		session.setAttribute("students", lister());
		//session.setAttribute("courses", getAllCourses());
		if(user.getProfil().equalsIgnoreCase("directeur")) {
			dispatcher = request.getRequestDispatcher("etudiant.jsp");
		}
		else {
			dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");

		}
		
		
		
		dispatcher.forward(request, response);
	}

	private List<Etudiant> lister() {

		List<Etudiant> students = Collections.emptyList();
		try {
			
//			students = studentService.getAllStudent();
			
			DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
			defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
			Client client = Client.create(defaultClientConfig);
			
			
			
			WebResource webResource = client.resource("http://localhost:8080/partielwebservice-webservice/rest/json/student/get");

			 students = webResource.get(new GenericType<List<Etudiant>>(){});
			
			
		} catch (Exception e) {

		}
		return students;
	}

}
