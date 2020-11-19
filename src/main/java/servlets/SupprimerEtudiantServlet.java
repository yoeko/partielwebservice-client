package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import domaine.Etudiant;
import domaine.User;


/**
 * Servlet implementation class SupprimerEtudiantServlet
 */
public class SupprimerEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private EtudiantService studentService;
//	private CoursService courseService;
	private RequestDispatcher dispatcher = null;
	private User user = null;
//	private IEtudiantDao etudiantDao = new EtudiantDao();

	/**
	 * Default constructor.
	 */
	public SupprimerEtudiantServlet() {
//		studentService = new EtudiantService(etudiantDao);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		methode(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String object = request.getParameter("id");
		int id = Integer.valueOf(object);
		
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		
		
		
		WebResource webResource = client.resource("http://localhost:8080/partielwebservice-webservice/rest/json/student/delete/"+id);

		webResource.type("application/json").delete(ClientResponse.class);
		
		

		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		
		user = (User) session.getAttribute("user");
		session.setAttribute("students", lister());
//		session.setAttribute("courses", getAllCours());
		session.setAttribute("student", null);
		
		
		session.setAttribute("message", "Suppression effectuée avec succès !!! ");
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
//
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
