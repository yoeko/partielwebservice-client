package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
 * Servlet implementation class ModifEtudiantServlet
 */
public class ModifEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private EtudiantService studentService;
	private RequestDispatcher dispatcher = null;
//	private CoursService courseService;
	private User user = null;
//	private IEtudiantDao etudiantDao = new EtudiantDao();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifEtudiantServlet() {
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

		Etudiant student = new Etudiant(
				
				request.getParameter("firstName"), 
				request.getParameter("lastName"),
				request.getParameter("mailAdresse"), 
				request.getParameter("adress"),
				request.getParameter("numberPhone"),
				new Date());
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(student);
		
		
		int idEtudiant = Integer.valueOf(request.getParameter("id"));

		HttpSession session = request.getSession();
		session.setAttribute("student", null);
		user = (User) session.getAttribute("user");

		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		
		
		WebResource webResource = client.resource("http://localhost:8080/partielwebservice-webservice/rest/json/student/update/"+idEtudiant);

		 webResource.type("application/json").put(ClientResponse.class, jsonString);
		
		

		session.setAttribute("student", null);
		session.setAttribute("students", lister());
//		session.setAttribute("courses", getAllCours());
		
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}

	private List<Etudiant> lister() {

		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		
		
		WebResource webResource = client.resource("http://localhost:8080/partielwebservice-webservice/rest/json/student/get");

		ClientResponse response2 = webResource.accept("application/json").get(ClientResponse.class);

		
		return (List<Etudiant>) response2.getEntity(new GenericType<List<Etudiant>>(){});
	}

//	private List<Cours> getAllCours() {
//
//		List<Cours> courses = Collections.emptyList();
//		try {
//
//			courses = courseService.getAllCours();
//		} catch (Exception e) {
//
//		}
//		return courses;
//	}
}
