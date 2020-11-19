package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import domaine.Etudiant;
import domaine.User;

/**
 * Servlet implementation class RechercheEtudiantServlet
 */
public class RechercheEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user = null;
//	private EtudiantService studentService;
//	private IEtudiantDao etudiantDao = new EtudiantDao();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercheEtudiantServlet() {
		super();
//		studentService = new EtudiantService(etudiantDao);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		session.setAttribute("student", null);
		user = (User) session.getAttribute("user");
//		List<Etudiant> students = studentService.getStudentByResearch(request.getParameter("firstNameR"), request.getParameter("lastNameR"));

		Client client = Client.create();
//		
		
		WebResource webResource = client.resource("http://localhost:8080/partielwebservice-webservice/rest/json/student/research/"+request.getParameter("firstNameR")+"/"+ request.getParameter("lastNameR"));

		ClientResponse response2 = webResource.accept("application/json").get(ClientResponse.class);

		List<Etudiant> students = response2.getEntity(new GenericType<List<Etudiant>>(){});
		
		
		session.setAttribute("students", students);
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}

}
